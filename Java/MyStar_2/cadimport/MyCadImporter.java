// STAR-CCM+ macro: CadImporter.java
package macro;

import java.util.*;
import java.lang.*;
import java.io.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import star.meshing.*;


public class MyCadImporter extends StarMacro {

	double tol;

	private Simulation simulation_0;
	private MeshPipelineController meshPipelineController;
	private SurfaceMeshProxy surfaceMeshProxy;
	
	public MeshContinuum meshContinuum;
	
	private FrontalAreaReport frontalAreaReport_x;
	private FrontalAreaReport frontalAreaReport_y;
	private FrontalAreaReport frontalAreaReport_z;
	
	public List<RegionSort> regionSortList;
	
	public void execute() {
		execute0();
	}
	private void execute0() {
		simulation_0 = getActiveSimulation();
		climbGeometryTree_split();
	}
	public class RegionSort {
		//public SortedMap<Double,Integer> mapList0[];
		
		public Region r;
		
		
		public List<Boundary> b;
		public List<Boundary> bipb;
		public List<SortedMap<Double,Boundary>> mapList;
		public List<List<Boundary>> extraList;
		//public SortedMap<Double,Boundary> mapList[];
		//public List<Boundary> extraList[];
		List<Boundary> internal;
		
		RegionSort(Region region) {
			//mapList0[0] = new TreeMap<Double,Integer>();
			//mapList0[1] = new TreeMap<Double,Integer>();
			//mapList0[0].put(1.0,1);
			
			Boundary boundary;
			
			r = region;
			
			// list initialization
			b = new ArrayList<Boundary>(r.getBoundaryManager().getBoundaries());
			bipb = new ArrayList<Boundary>();
			mapList = new ArrayList<SortedMap<Double,Boundary>>();
			extraList = new ArrayList<List<Boundary>>();
			for (int j=0; j<3; j++) {
				mapList.add(new TreeMap<Double,Boundary>());
				extraList.add(new ArrayList<Boundary>());
			}
			//x = new TreeMap<Double,Boundary>();
			//extra_x = new ArrayList<Boundary>();
			internal = new ArrayList<Boundary>();
			
			// print some stuff
			
			simulation_0.println("region: "+r.getPresentationName());
			simulation_0.println("\tcontains "+b.size()+" boundaries");
			
			DirectBoundaryInterface directBoundaryInterface;
			
			for (Interface iface: simulation_0.getInterfaceManager().getObjects()) {
				if (iface.getClass().equals(DirectBoundaryInterface.class)) {
					directBoundaryInterface = (DirectBoundaryInterface)iface;
					if ( directBoundaryInterface.getRegion0()==r ) {
						b.remove(directBoundaryInterface.getParentBoundary0());
						bipb.add(directBoundaryInterface.getParentBoundary0());
					} else if ( directBoundaryInterface.getRegion1()==r ) {
						b.remove(directBoundaryInterface.getParentBoundary1());
						bipb.add(directBoundaryInterface.getParentBoundary1());
					}
				}
			}
			
			Iterator i = b.iterator();
			
			AreaClass areaClass;
			boolean fail;
			
			while ( i.hasNext() )
			{
				boundary = ((Boundary) i.next());
				
				if ( boundary.getBoundaryType().getClass().equals(InternalBoundary.class) ) {
					i.remove();
					internal.add(boundary);
				} else {
					areaClass = new AreaClass(boundary);
					
					for ( int j=0; j<3; j++ ) {
						fail=false;
						for ( int k=0; k<3; k++ ) {
							if ( j==k ) {
								if ( areaClass.area[k]<tol ) { fail=true; }
							} else {
								if ( areaClass.area[k]>tol ) { fail=true; }
							}
						}
						if (!fail) {
							i.remove();
							if (mapList.get(j).containsKey(areaClass.area[j])) {
								extraList.get(j).add(boundary);
							} else {
								mapList.get(j).put(areaClass.area[j],boundary);
							}
							break;
						}
					}
				}
			}
		}
		public void print() {
			simulation_0.println(r.getPresentationName());
			simulation_0.println("\tb");
			printList(b);
			simulation_0.println("\tx");
			simulation_0.println(mapList.get(0));
			simulation_0.println("\ty");
			simulation_0.println(mapList.get(1));
			simulation_0.println("\tz");
			simulation_0.println(mapList.get(2));
			simulation_0.println("\textra_x");
			simulation_0.println(extraList.get(0));
			simulation_0.println("\textra_y");
			simulation_0.println(extraList.get(1));
			simulation_0.println("\textra_z");
			simulation_0.println(extraList.get(2));
		}
		void printList(List<Boundary> b) {
			Boundary boundary;
			Iterator i = b.iterator();
			
			AreaClass ac;
			
			while ( i.hasNext() )
			{
				boundary = ((Boundary) i.next());
				ac = new AreaClass(boundary);
				simulation_0.println("\t\t"+boundary.getPresentationName()+" "+boundary.getBoundaryType().getPresentationName()+" "+ac.area[0]+" "+ac.area[1]+" "+ac.area[2]);
			}
		}
	}
	/*
	public MyCadImporter(Simulation sim) {
		simulation_0 = sim;
	}
	*/
	public void importCAD(String CADFilename) {
		tol = 1e-17;
		
		PartImportManager partImportManager_0 = simulation_0.get(PartImportManager.class);
		partImportManager_0.importCadPart(CADFilename, "SharpEdges", 30.0, 2, true, true);
		
		climbGeometryTree_split();
		climbGeometryTree_createRegion();
		
		MeshContinuum meshContinuum = simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);
		MeshPipelineController meshPipelineController = simulation_0.get(MeshPipelineController.class);
		meshPipelineController.generateSurfaceMesh();
		surfaceMeshProxy = simulation_0.get(SurfaceMeshProxy.class);
		
		initializeFrontalAreaReport();
		
		regionSortList = new ArrayList<RegionSort>();
		
		for (Region region: simulation_0.getRegionManager().getRegions() ) {	
			regionSortList.add(new RegionSort(region));
		}
	}
	private class AreaClass {
		double area[];
		
		AreaClass() {
			area = new double[3];
		}
		AreaClass(Boundary boundary) {
			area = new double[3];
			
			frontalAreaReport_x.getParts().setObjects(boundary);
			frontalAreaReport_y.getParts().setObjects(boundary);
			frontalAreaReport_z.getParts().setObjects(boundary);
			
			area[0] = frontalAreaReport_x.getValue();
			area[1] = frontalAreaReport_y.getValue();
			area[2] = frontalAreaReport_z.getValue();
		}
	}
	private void initializeFrontalAreaReport() {
		frontalAreaReport_x = simulation_0.getReportManager().createReport(FrontalAreaReport.class);
		frontalAreaReport_y = simulation_0.getReportManager().createReport(FrontalAreaReport.class);
		frontalAreaReport_z = simulation_0.getReportManager().createReport(FrontalAreaReport.class);
		
		Units units_0 = simulation_0.getUnitsManager().getObject("m");
		
		Coordinate coordinate_0 = frontalAreaReport_x.getNormalCoordinate();
		Coordinate coordinate_1 = frontalAreaReport_x.getViewUpCoordinate();
		
		coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));
		coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 1.0}));
		
		coordinate_0 = frontalAreaReport_y.getNormalCoordinate();
		coordinate_1 = frontalAreaReport_y.getViewUpCoordinate();
		
		coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));
		coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));
		
		coordinate_0 = frontalAreaReport_z.getNormalCoordinate();
		coordinate_1 = frontalAreaReport_z.getViewUpCoordinate();
		
		coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 1.0}));
		coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));
	}
	private void climbGeometryTree_split() {
		for (GeometryPart geometryPart: simulation_0.getGeometryPartManager().getParts())
		{
			climbGeometryTree_split_recursive(geometryPart);
		}
	}
	private void climbGeometryTree_split_recursive(GeometryPart geometryPart) {
		//Vector<PartSurface> partSurfaceVector;
		if (geometryPart.isLeaf()) {
			for (PartSurface partSurface: geometryPart.getPartSurfaces()) {
				//partSurfaceVector = new Vector<PartSurface>(geometryPart.getPartSurfaces());
				partSurface.getManager().splitPartSurfacesByPartCurves(new Vector<PartSurface>(geometryPart.getPartSurfaces()),new Vector<PartCurve>(geometryPart.getPartCurves()));
				break;
			}
		} else {
			for (GeometryPart geometryPart_0: geometryPart.getLeafParts()) {
				climbGeometryTree_split_recursive(geometryPart_0);
			}
		}
	}
	private void climbGeometryTree_createRegion() {
		List<GeometryPart> list = new ArrayList<GeometryPart>();
		
		for (GeometryPart geometryPart: simulation_0.getGeometryPartManager().getParts())
		{
			list.addAll(climbGeometryTree_createRegion_recursive(geometryPart));
		}
		
		simulation_0.getRegionManager().newRegionsFromParts(list, "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", null, true);
	}
	private List<GeometryPart> climbGeometryTree_createRegion_recursive(GeometryPart geometryPart) {
		List<GeometryPart> list = new ArrayList<GeometryPart>();
		
		if (geometryPart.isLeaf()) {
			list.add(geometryPart);
		} else {
			for (GeometryPart geometryPart_0: geometryPart.getLeafParts()) {
				list.addAll(climbGeometryTree_createRegion_recursive(geometryPart_0));
			}
		}
		
		return list;
	}
}
