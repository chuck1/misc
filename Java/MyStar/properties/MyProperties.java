// STAR-CCM+ macro: Properties.java
package MyStar.properties;

import java.util.*;
import java.lang.*;

import star.base.neo.*;
import star.turbulence.*;
import star.material.*;
import star.common.*;
import star.coupledflow.*;
import star.segregatedenergy.*;
import star.flow.*;
import star.metrics.*;
import star.segregatedflow.*;
import star.energy.*;



public class MyProperties {
	public static void continua_physics_fluid(PhysicsContinuum physicsContinuum) {
	
		SingleComponentGasModel singleComponentGasModel_0 = physicsContinuum.getModelManager().getModel(SingleComponentGasModel.class);
		Gas gas_0 = ((Gas) singleComponentGasModel_0.getMaterial());
		
		// density
		TemperaturePolynomial temperaturePolynomial_0 = ((TemperaturePolynomial) gas_0.getMaterialProperties().getMaterialProperty(PolynomialDensityProperty.class).getMethod());
		
		temperaturePolynomial_0.getPolynomial().setIntervalRanges(new DoubleVector(new double[] {100.0, 1100.0}));
		temperaturePolynomial_0.getPolynomial().setCoefficients(new DoubleVector(new double[] {211.6808, -0.2725829, 1.12436E-4}));
		
		// dynamic viscosity
		gas_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).setMethod(PowerLaw.class);
		
		PowerLaw powerLaw_0 = ((PowerLaw) gas_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());

		powerLaw_0.setReferenceValue(2.894345E-5);
		powerLaw_0.setReferenceTemperature(600.0);
		powerLaw_0.setTemperatureExponent(0.7071589);
		
		// specific heat
		gas_0.getMaterialProperties().getMaterialProperty(SpecificHeatProperty.class).setMethod(PolynomialSpecificHeat.class);
		
		PolynomialSpecificHeat polynomialSpecificHeat_0 = ((PolynomialSpecificHeat) gas_0.getMaterialProperties().getMaterialProperty(SpecificHeatProperty.class).getMethod());
		
		polynomialSpecificHeat_0.getPolynomial().setIntervalRanges(new DoubleVector(new double[] {100.0, 1100.0}));
		polynomialSpecificHeat_0.getPolynomial().setNumberOfCoefficients(new IntVector(new int[] {3}));
		polynomialSpecificHeat_0.getPolynomial().setCoefficients(new DoubleVector(new double[] {970.372, 0.3319256, -4.833853E-5}));
		polynomialSpecificHeat_0.getPolynomial().setExponents(new DoubleVector(new double[] {0.0, 1.0, 2.0}));
		
		// thermal conductivity
		gas_0.getMaterialProperties().getMaterialProperty(ThermalConductivityProperty.class).setMethod(PowerLaw.class);

		PowerLaw powerLaw_1 = ((PowerLaw) gas_0.getMaterialProperties().getMaterialProperty(ThermalConductivityProperty.class).getMethod());

		powerLaw_1.setReferenceValue(0.04443491);
		powerLaw_1.setReferenceTemperature(600.0);
		powerLaw_1.setTemperatureExponent(0.9355018);
		
		// turbulent prandtl number
		ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(TurbulentPrandtlNumberProperty.class).getMethod());
		
		constantMaterialPropertyMethod_0.getQuantity().setValue(1.0);
		
	}
	public static void continua_physics_solid(PhysicsContinuum physicsContinuum) {
		
		SolidModel solidModel_0 = physicsContinuum.getModelManager().getModel(SolidModel.class);
		Solid solid_0 = ((Solid) solidModel_0.getMaterial());

		// density
		ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = ((ConstantMaterialPropertyMethod) solid_0.getMaterialProperties().getMaterialProperty(ConstantDensityProperty.class).getMethod());
		
		constantMaterialPropertyMethod_1.getQuantity().setValue(8050.0);
		
		// specific heat
		ConstantSpecificHeat constantSpecificHeat_0 = ((ConstantSpecificHeat) solid_0.getMaterialProperties().getMaterialProperty(SpecificHeatProperty.class).getMethod());
		
		constantSpecificHeat_0.getQuantity().setValue(728.0);

		// thermal conductivity
		ConstantMaterialPropertyMethod constantMaterialPropertyMethod_2 = ((ConstantMaterialPropertyMethod) solid_0.getMaterialProperties().getMaterialProperty(ThermalConductivityProperty.class).getMethod());
		
		constantMaterialPropertyMethod_2.getQuantity().setValue(31.0);
	}
}
