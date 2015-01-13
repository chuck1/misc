// STAR-CCM+ macro: partsurface_selection1.java
package macro;

import java.util.*;
import java.lang.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import star.meshing.*;

public class partsurface_selection1 extends StarMacro {

	double tol;

	private Simulation simulation_0;
	MeshPipelineController meshPipelineController;
	SurfaceMeshProxy surfaceMeshProxy;
	
	MeshContinuum meshContinuum_fluid;
	
	FrontalAreaReport frontalAreaReport_x;
	FrontalAreaReport frontalAreaReport_y;
	FrontalAreaReport frontalAreaReport_z;
	
	// pin_duct_assem
	RegionSort regionSort_fluid;
	RegionSort regionSort_solid;
	
	
	Boundary boundary_inlet;
	Boundary boundary_outlet;
	Boundary boundary_fluid_symmetry;
	Boundary boundary_fluid_interior;
	
	List<Boundary> boundaryList_fluid_symmetry;
	
	Boundary boundary_top;
	Boundary boundary_bottom;
	Boundary boundary_solid_symmetry;
	Boundary boundary_solid_interior;
	
	List<Boundary> boundaryList_solid_symmetry;
	List<Boundary> boundaryList_solid_interior;
	
	// parameters
	double D;
	double P_T;
	double N_T;
	double baseSizeRatio;
	int numPrismLayers;
	
	
	public void execute() {
		execute0();
	}
	private class RegionSort {
		Region r;
		
		List<Boundary> b;
		List<Boundary> bipb;
		//List<SortedMap<Double,Boundary>> mapList;
		SortedMap<Double,Boundary> x;
		SortedMap<Double,Boundary> y;
		SortedMap<Double,Boundary> z;
		//List<List<Boundary>> extraList;
		List<Boundary> extra_x;
		List<Boundary> extra_y;
		List<Boundary> extra_z;
		List<Boundary> internal;
		
		RegionSort(Region region) {
			Boundary boundary;
			
			r = region;
			
			simulation_0.println("region: "+r.getPresentationName());
			
			b = new ArrayList<Boundary>(r.getBoundaryManager().getBoundaries());
			bipb = new ArrayList<Boundary>();
			x = new TreeMap<Double,Boundary>();
			y = new TreeMap<Double,Boundary>();
			z = new TreeMap<Double,Boundary>();
			extra_x = new ArrayList<Boundary>();
			extra_y = new ArrayList<Boundary>();
			extra_z = new ArrayList<Boundary>();
			internal = new ArrayList<Boundary>();
			
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
			
			while ( i.hasNext() )
			{
				boundary = ((Boundary) i.next());
				
				if ( boundary.getBoundaryType().getClass().equals(InternalBoundary.class) ) {
					i.remove();
					internal.add(boundary);
				} else {
					areaClass = new AreaClass(boundary);
					/*
					for ( int j=0; j<3; j++ ) {
						for ( int k=0; k<3; k++ ) {
							if ( j==k ) {
								if ( areaClass.area[k]<tol ) {
									continue;
								}
							} else {
								if ( areaClass.area[k]>tol ) {
									continue;
								}
							}
						}
						
						i.remove();
						if (mapList.get(j).containsKey(areaClass.area[j])) {
							extra_x.add(boundary);
						} else {
							mapList.get(j).put(areaClass.area[j],boundary);
						}
						break;
						
					}
					*/
					if ( areaClass.area[0]>tol && areaClass.area[1]<tol && areaClass.area[2]<tol) {
						i.remove();
						if (x.containsKey(areaClass.area[0])) {
							extra_x.add(boundary);
						} else {
							x.put(areaClass.area[0],boundary);
						}
					} else if ( areaClass.area[0]<tol && areaClass.area[1]>tol && areaClass.area[2]<tol) {
						i.remove();
						if (y.containsKey(areaClass.area[1])) {
							extra_y.add(boundary);
						} else {
							y.put(areaClass.area[1],boundary);
						}
					} else if ( areaClass.area[0]<tol && areaClass.area[1]<tol && areaClass.area[2]>tol) {
						i.remove();
						if (z.containsKey(areaClass.area[2])) {
							extra_z.add(boundary);
						} else {
							z.put(areaClass.area[2],boundary);
						}
					}
				}
			}
		}
		void print() {
			simulation_0.println(r.getPresentationName());
			simulation_0.println("\tb");
			printList(b);
			simulation_0.println("\tx");
			simulation_0.println(x);
			simulation_0.println("\ty");
			simulation_0.println(y);
			simulation_0.println("\tz");
			simulation_0.println(z);
			simulation_0.println("\textra_x");
			simulation_0.println(extra_x);
			simulation_0.println("\textra_y");
			simulation_0.println(extra_y);
			simulation_0.println("\textra_z");
			simulation_0.println(extra_z);
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
	private void execute0() {
		simulation_0 = getActiveSimulation();
		
		topology();
		
		load_param();
		
		
	}
	private void topology() {
		tol = 1e-17;
		
		
		PartImportManager partImportManager_0 = simulation_0.get(PartImportManager.class);
		partImportManager_0.importCadPart(resolvePath("Z:\\Windows.Documents\\My Documents\\SYNC\\SUNSHOT\\solidworks\\clust\\pin_circ_stag_duct\\pin_duct_assem2_case_0004.x_b"), "SharpEdges", 30.0, 2, true, true);

		
		
		for (GeometryPart geometryPart: simulation_0.getGeometryPartManager().getParts())
		{
			climbGeometryTree_split(geometryPart);
		}
		
		for (GeometryPart geometryPart: simulation_0.getGeometryPartManager().getParts())
		{
			simulation_0.getRegionManager().newRegionsFromParts(new Vector(geometryPart.getLeafParts()), "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", null, true);
			break;
		}
		
		MeshContinuum meshContinuum_fluid = simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);
		meshContinuum_fluid.setPresentationName("mesh fluid");
		MeshPipelineController meshPipelineController = simulation_0.get(MeshPipelineController.class);
		meshPipelineController.generateSurfaceMesh();
		surfaceMeshProxy = simulation_0.get(SurfaceMeshProxy.class);
		
		initializeFrontalAreaReport();
		
		RegionSort regionSort;
		
		for (Region region: simulation_0.getRegionManager().getRegions() ) {	
			regionSort = new RegionSort(region);
			
			if ((regionSort.x.size()+regionSort.extra_x.size())==2) {
				regionSort_solid = regionSort;
			} else {
				regionSort_fluid = regionSort;
			}
		}
		
		regionSort_fluid.r.setPresentationName("fluid");
		regionSort_solid.r.setPresentationName("solid");
		
		
		// solid top
		boundary_top = regionSort_solid.y.remove(regionSort_solid.y.lastKey());
		// solid bottom
		boundary_bottom = regionSort_solid.y.remove(regionSort_solid.y.lastKey());
		
		// fluid symmetry
		boundaryList_fluid_symmetry = new ArrayList<Boundary>();
		
		boundaryList_fluid_symmetry.addAll(regionSort_fluid.x.values());
		regionSort_fluid.x.clear();
		boundaryList_fluid_symmetry.addAll(regionSort_fluid.extra_x);
		regionSort_fluid.extra_x.clear();
		boundaryList_fluid_symmetry.addAll(regionSort_fluid.z.values());
		regionSort_fluid.z.clear();
		boundaryList_fluid_symmetry.addAll(regionSort_fluid.extra_z);
		regionSort_fluid.extra_z.clear();
		
		simulation_0.println("fluid symmetry:");
		simulation_0.println(boundaryList_fluid_symmetry);
		
		boundary_fluid_symmetry = boundaryList_fluid_symmetry.get(0);
		surfaceMeshProxy.combineBoundaries(new Vector(boundaryList_fluid_symmetry));
		
		simulation_0.println("fluid symmetry combined:");
		simulation_0.println(boundary_fluid_symmetry);
		
		// solid symmetry
		boundaryList_solid_symmetry = new ArrayList<Boundary>();
		
		boundaryList_solid_symmetry.addAll(regionSort_solid.x.values());
		regionSort_solid.x.clear();
		boundaryList_solid_symmetry.addAll(regionSort_solid.extra_x);
		regionSort_solid.extra_x.clear();
		boundaryList_solid_symmetry.addAll(regionSort_solid.z.values());
		regionSort_solid.z.clear();
		boundaryList_solid_symmetry.addAll(regionSort_solid.extra_z);
		regionSort_solid.extra_z.clear();
		
		simulation_0.println("solid symmetry:");
		simulation_0.println(boundaryList_solid_symmetry);
		
		boundary_solid_symmetry = boundaryList_solid_symmetry.get(0);
		surfaceMeshProxy.combineBoundaries(new Vector(boundaryList_solid_symmetry));
		
		simulation_0.println("solid symmetry combined:");
		simulation_0.println(boundary_solid_symmetry);
		
		
		// solid interior
		boundaryList_solid_interior = new ArrayList<Boundary>();
		
		boundaryList_solid_interior.addAll(regionSort_solid.bipb);
		regionSort_solid.bipb.clear();
		
		simulation_0.println("solid interior:");
		simulation_0.println(boundaryList_solid_interior);
		
		boundary_solid_interior = boundaryList_solid_interior.get(0);
		surfaceMeshProxy.combineBoundaries(new Vector(boundaryList_solid_interior));
		
		simulation_0.println("solid interior combined:");
		simulation_0.println(boundary_solid_interior);
		
		// fluid inlet
		if ( !regionSort_fluid.y.isEmpty() ) {
			boundary_inlet = regionSort_fluid.y.remove(regionSort_fluid.y.firstKey());
		} else {
		}
		
		// fluid outlet
		if ( !regionSort_fluid.y.isEmpty() ) {
			boundary_outlet = regionSort_fluid.y.remove(regionSort_fluid.y.firstKey());
		} else if ( !regionSort_fluid.extra_y.isEmpty() ) {
			boundary_outlet = regionSort_fluid.extra_y.remove(0);
		} else {
		}
		
		// fluid interior
		if ( !regionSort_fluid.bipb.isEmpty() ) {
			boundary_fluid_interior = regionSort_fluid.bipb.remove(0);
		} else {
		}
		
		// edit names
		boundary_inlet.setPresentationName("inlet");
		boundary_outlet.setPresentationName("outlet");
		boundary_fluid_symmetry.setPresentationName("symmetry");
		boundary_fluid_interior.setPresentationName("interior");
		
		boundary_top.setPresentationName("top");
		boundary_bottom.setPresentationName("bottom");
		boundary_solid_symmetry.setPresentationName("symmetry");
		boundary_solid_interior.setPresentationName("interior");
		
		// show remaining
		regionSort_fluid.print();
		regionSort_solid.print();
		
		
		
	}
	private void load_param() {
	
		CsvReader csvReader_0 = new CsvReader(session_abs_dir+"/csv_param.csv",2);
		Collection<String> strings_0 = csvReader_0.getValues();
		Iterator it = strings_0.iterator();
		Field field;
		
		while (it.hasNext()) {
			field = partsurface_selection1.class.getField(it.next());
			switch (field.getType()) {
				case Double.class:
					field.set(this,Double.parseDouble(it.next()));
					break;
				case Integer.class:
					field.set(this,Integer.parseInteger(it.next()));
					break;
				default:
					break;
			}
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
		
		Units units_0 = ((Units) simulation_0.getUnitsManager().getObject("m"));
		
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
	private void climbGeometryTree_split(GeometryPart geometryPart) {
		simulation_0.println(geometryPart.getPresentationName() + " " + geometryPart.isLeaf());
		if (geometryPart.isLeaf()) {
			for (PartSurface partSurface: geometryPart.getPartSurfaces()) {
				partSurface.getManager().splitPartSurfacesByPartCurves(new Vector(geometryPart.getPartSurfaces()),new Vector(geometryPart.getPartCurves()));
				break;
			}
		} else {
			for (GeometryPart geometryPart_0: geometryPart.getLeafParts()) {
				climbGeometryTree_split(geometryPart_0);
			}
		}
	}
	private void climbGeometryTree_createRegion(GeometryPart geometryPart) {
		if (geometryPart.isLeaf()) {
			simulation_0.getRegionManager().newRegionsFromParts(new ArrayList<GeometryPart>(Arrays.asList(geometryPart)), "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", null, true);
		} else {
			for (GeometryPart geometryPart_0: geometryPart.getLeafParts()) {
				climbGeometryTree_createRegion(geometryPart_0);
			}
		}
	}
	private Report MyStarCreateReport(String type,String name,String fieldFunction,Boundary boundary) {
		Report report;
		PrimitiveFieldFunction primitiveFieldFunction = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Temperature"));
		boolean isExpression = false;
		switch (type) {
			case "AreaAverageReport":
				report = simulation_0.getReportManager().createReport(AreaAverageReport.class);
				break;
			case "MassFlowAverageReport":
				report = simulation_0.getReportManager().createReport(MassFlowAverageReport.class);
				break;
			case "Expression":
				report = simulation_0.getReportManager().createReport(ExpressionReport.class);
				isExpression = true;
				break;
			default:
				break;
		}
		if (isExpression) {
			report.setDefinition(fieldFunction);
		} else {
			primitiveFieldFunction = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction(fieldFunction));
			report.setScalar(primitiveFieldFunction);
			report.getParts().setObjects(boundary);
		}
		report.setPresentationName(name);
		return report;
	}
}
