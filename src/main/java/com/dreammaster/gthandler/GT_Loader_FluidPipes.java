package com.dreammaster.gthandler;

import gregtech.api.enums.GTNH_ExtraMaterials;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.metatileentity.implementations.GT_MetaPipeEntity_Fluid;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_OreDictUnificator;

public class GT_Loader_FluidPipes
{
	public void run()
	{
		registerHighTierPipes();
	}

	private void registerHighTierPipes()
	{
		// 5110 - 5114 Copper
		// 5120 - 5124 Bronze
		// 5130 - 5134 Steel
		// 5140 - 5144 Stainless
		// 5150 - 5154 Titanium
		// 5160 - 5164 Tungstensteel
		// 5165 - 5167 High Pressure Pipe
		// 5168 - Plasma Pipe
		// 5170 - 5174 Plastic
		
		// 5180 - 5187 NiobiumTitanium
	    /*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.NiobiumTitanium), new GT_MetaPipeEntity_Fluid(5180, "GT_Pipe_NiobiumTitanium_Tiny", "Tiny Niobium-Titanium Fluid Pipe", 0.25F, Materials.NiobiumTitanium, 150, 2900, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.NiobiumTitanium), new GT_MetaPipeEntity_Fluid(5181, "GT_Pipe_NiobiumTitanium_Small", "Small Niobium-Titanium Fluid Pipe", 0.375F, Materials.NiobiumTitanium, 300, 2900, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.NiobiumTitanium), new GT_MetaPipeEntity_Fluid(5182, "GT_Pipe_NiobiumTitanium", "Niobium-Titanium Fluid Pipe", 0.5F, Materials.NiobiumTitanium, 900, 2900, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.NiobiumTitanium), new GT_MetaPipeEntity_Fluid(5183, "GT_Pipe_NiobiumTitanium_Large", "Large Niobium-Titanium Fluid Pipe", 0.75F, Materials.NiobiumTitanium, 2400, 2900, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.NiobiumTitanium), new GT_MetaPipeEntity_Fluid(5184, "GT_Pipe_NiobiumTitanium_Huge", "Huge Niobium-Titanium Fluid Pipe", 0.875F, Materials.NiobiumTitanium, 3600, 2900, true).getStackForm(1L));*/
	    generateFluidPipes(Materials.NiobiumTitanium, Materials.NiobiumTitanium.mName, 5180, 900, 2900, true);
		generateFluidMultiPipes(Materials.NiobiumTitanium, Materials.NiobiumTitanium.mName, 5185, 900, 2900, true);

		// 5190 - 5197 Enderium
		/*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.Enderium), new GT_MetaPipeEntity_Fluid(5190, "GT_Pipe_Enderium_Tiny", "Tiny Enderium Fluid Pipe", 0.25F, Materials.Enderium, 300, 15000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Enderium), new GT_MetaPipeEntity_Fluid(5191, "GT_Pipe_Enderium_Small", "Small Enderium Fluid Pipe", 0.375F, Materials.Enderium, 600, 15000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.Enderium), new GT_MetaPipeEntity_Fluid(5192, "GT_Pipe_Enderium", "Enderium Fluid Pipe", 0.5F, Materials.Enderium, 1800, 15000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.Enderium), new GT_MetaPipeEntity_Fluid(5193, "GT_Pipe_Enderium_Large", "Large Enderium Fluid Pipe", 0.75F, Materials.Enderium, 4800, 15000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.Enderium), new GT_MetaPipeEntity_Fluid(5194, "GT_Pipe_Enderium_Huge", "Huge Enderium Fluid Pipe", 0.875F, Materials.Enderium, 7200, 15000, true).getStackForm(1L));*/
	    generateFluidPipes(Materials.Enderium, Materials.Enderium.mName, 5190, 1800, 15000, true);
		generateFluidMultiPipes(Materials.Enderium, Materials.Enderium.mName, 5195, 1800, 15000, true);

	    // 5200 - 5207 Naquadah
	    /*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.Naquadah), new GT_MetaPipeEntity_Fluid(5200, "GT_Pipe_Naquadah_Tiny", "Tiny Naquadah Fluid Pipe", 0.25F, Materials.Naquadah, 1500, 19000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Naquadah), new GT_MetaPipeEntity_Fluid(5201, "GT_Pipe_Naquadah_Small", "Small Naquadah Fluid Pipe", 0.375F, Materials.Naquadah, 3000, 19000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.Naquadah), new GT_MetaPipeEntity_Fluid(5202, "GT_Pipe_Naquadah", "Naquadah Fluid Pipe", 0.5F, Materials.Naquadah, 9000, 19000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.Naquadah), new GT_MetaPipeEntity_Fluid(5203, "GT_Pipe_Naquadah_Large", "Large Naquadah Fluid Pipe", 0.75F, Materials.Naquadah, 24000, 19000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.Naquadah), new GT_MetaPipeEntity_Fluid(5204, "GT_Pipe_Naquadah_Huge", "Huge Naquadah Fluid Pipe", 0.875F, Materials.Naquadah, 36000, 19000, true).getStackForm(1L));*/
	    generateFluidPipes(Materials.Naquadah, Materials.Naquadah.mName, 5200, 9000, 19000, true);
		generateFluidMultiPipes(Materials.Naquadah, Materials.Naquadah.mName, 5205, 9000, 19000, true);

	    // 5210 - 5217 Neutronium
	    /*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.Neutronium), new GT_MetaPipeEntity_Fluid(5210, "GT_Pipe_Neutronium_Tiny", "Tiny Neutronium Fluid Pipe", 0.25F, Materials.Neutronium, 2800, 1000000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Neutronium), new GT_MetaPipeEntity_Fluid(5211, "GT_Pipe_Neutronium_Small", "Small Neutronium Fluid Pipe", 0.375F, Materials.Neutronium, 5600, 1000000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.Neutronium), new GT_MetaPipeEntity_Fluid(5212, "GT_Pipe_Neutronium", "Neutronium Fluid Pipe", 0.5F, Materials.Neutronium, 16800, 1000000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.Neutronium), new GT_MetaPipeEntity_Fluid(5213, "GT_Pipe_Neutronium_Large", "Large Neutronium Fluid Pipe", 0.75F, Materials.Neutronium, 44800, 1000000, true).getStackForm(1L));
	    GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.Neutronium), new GT_MetaPipeEntity_Fluid(5214, "GT_Pipe_Neutronium_Huge", "Huge Neutronium Fluid Pipe", 0.875F, Materials.Neutronium, 67200, 1000000, true).getStackForm(1L));*/
	    generateFluidPipes(Materials.Neutronium, Materials.Neutronium.mName, 5210, 16800, 1000000, true);
		generateFluidMultiPipes(Materials.Neutronium, Materials.Neutronium.mName, 5215, 16800, 1000000, true);

		// 5220 - 5227 Nether Star
		/*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.NetherStar), new GT_MetaPipeEntity_Fluid(5220, "GT_Pipe_Nether_Star_Tiny", "Tiny Nether Star Fluid Pipe", 0.25F, Materials.NetherStar, 3200, 1000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.NetherStar), new GT_MetaPipeEntity_Fluid(5221, "GT_Pipe_Nether_Star_Small", "Small Nether Star Fluid Pipe", 0.375F, Materials.NetherStar, 6400, 1000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.NetherStar), new GT_MetaPipeEntity_Fluid(5222, "GT_Pipe_Nether_Star", "Nether Star Fluid Pipe", 0.5F, Materials.NetherStar, 19200, 1000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.NetherStar), new GT_MetaPipeEntity_Fluid(5223, "GT_Pipe_Nether_Star_Large", "Large Nether Star Fluid Pipe", 0.75F, Materials.NetherStar, 51200, 1000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.NetherStar), new GT_MetaPipeEntity_Fluid(5224, "GT_Pipe_Nether_Star_Huge", "Huge Nether Star Fluid Pipe", 0.875F, Materials.NetherStar, 76800, 1000000, true).getStackForm(1L));*/
		generateFluidPipes(Materials.NetherStar, Materials.NetherStar.mName, 5220, 19200, 1000000, true);
		generateFluidMultiPipes(Materials.NetherStar, Materials.NetherStar.mName, 5225, 19200, 1000000, true);

		// 5230 - 5237 Mysteroius Crystal
		/*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.MysteriousCrystal), new GT_MetaPipeEntity_Fluid(5230, "GT_Pipe_MysteriousCrystal_Tiny", "Tiny Mysterious Crystal Fluid Pipe", 0.25F, Materials.MysteriousCrystal, 4000, 1000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.MysteriousCrystal), new GT_MetaPipeEntity_Fluid(5231, "GT_Pipe_MysteriousCrystal_Small", "Small Mysterious Crystal Fluid Pipe", 0.375F, Materials.MysteriousCrystal, 8000, 1000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.MysteriousCrystal), new GT_MetaPipeEntity_Fluid(5232, "GT_Pipe_MysteriousCrystal", "Mysterious Crystal Fluid Pipe", 0.5F, Materials.MysteriousCrystal, 24000, 1000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.MysteriousCrystal), new GT_MetaPipeEntity_Fluid(5233, "GT_Pipe_MysteriousCrystal_Large", "Large Mysterious Crystal Fluid Pipe", 0.75F, Materials.MysteriousCrystal, 64000, 1000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.MysteriousCrystal), new GT_MetaPipeEntity_Fluid(5234, "GT_Pipe_MysteriousCrystal_Huge", "Huge Mysterious Crystal Fluid Pipe", 0.875F, Materials.MysteriousCrystal, 96000, 1000000, true).getStackForm(1L));*/
		generateFluidPipes(Materials.MysteriousCrystal, Materials.MysteriousCrystal.mName, 5230, 24000, 1000000, true);
		generateFluidMultiPipes(Materials.MysteriousCrystal, Materials.MysteriousCrystal.mName, 5235, 24000, 1000000, true);

		// 5240 - 5247 Awakened Draconium
		/*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.DraconiumAwakened), new GT_MetaPipeEntity_Fluid(5240, "GT_Pipe_Awakened_Draconium_Tiny", "Tiny Awakened Draconium Fluid Pipe", 0.25F, Materials.DraconiumAwakened, 7500, 10000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.DraconiumAwakened), new GT_MetaPipeEntity_Fluid(5241, "GT_Pipe_Awakened_Draconium_Small", "Small Awakened Draconium Fluid Pipe", 0.375F, Materials.DraconiumAwakened, 15000, 10000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.DraconiumAwakened), new GT_MetaPipeEntity_Fluid(5242, "GT_Pipe_Awakened_Draconium", "Awakened Draconium Fluid Pipe", 0.5F, Materials.DraconiumAwakened, 45000, 10000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.DraconiumAwakened), new GT_MetaPipeEntity_Fluid(5243, "GT_Pipe_Awakened_Draconium_Large", "Large Awakened Draconium Fluid Pipe", 0.75F, Materials.DraconiumAwakened, 120000, 10000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.DraconiumAwakened), new GT_MetaPipeEntity_Fluid(5244, "GT_Pipe_Awakened_Draconiumr_Huge", "Huge Awakened Draconium Fluid Pipe", 0.875F, Materials.DraconiumAwakened, 180000, 10000000, true).getStackForm(1L));*/
		generateFluidPipes(Materials.DraconiumAwakened, Materials.DraconiumAwakened.mName, 5240, 45000, 10000000, true);
		generateFluidMultiPipes(Materials.DraconiumAwakened, Materials.DraconiumAwakened.mName, 5245, 45000, 10000000, true);

		// 5250 - 5257 Infinity
		/*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.Infinity), new GT_MetaPipeEntity_Fluid(5250, "GT_Pipe_Infinity_Tiny", "Tiny Infinity Fluid Pipe", 0.25F, Materials.Infinity, 10000, 10000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.Infinity), new GT_MetaPipeEntity_Fluid(5251, "GT_Pipe_Infinity_Small", "Small Infinity Fluid Pipe", 0.375F, Materials.Infinity, 20000, 10000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.Infinity), new GT_MetaPipeEntity_Fluid(5252, "GT_Pipe_Infinity", "Infinity Fluid Pipe", 0.5F, Materials.Infinity, 60000, 10000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.Infinity), new GT_MetaPipeEntity_Fluid(5253, "GT_Pipe_Infinity_Large", "Large Infinity Fluid Pipe", 0.75F, Materials.Infinity, 160000, 10000000, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.Infinity), new GT_MetaPipeEntity_Fluid(5254, "GT_Pipe_Infinity_Huge", "Huge Infinity Fluid Pipe", 0.875F, Materials.Infinity, 240000, 10000000, true).getStackForm(1L));*/
		generateFluidPipes(Materials.Infinity, Materials.Infinity.mName, 5250, 60000, 10000000, true);
		generateFluidMultiPipes(Materials.Infinity, Materials.Infinity.mName, 5255, 60000, 10000000, true);

		// 5260 - 5267 Wrough Iron
		/*GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(Materials.WroughtIron), new GT_MetaPipeEntity_Fluid(5260, "GT_Pipe_WroughtIron_Tiny", "Tiny Wrought Iron Fluid Pipe", 0.25F, Materials.WroughtIron, 30, 2250, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(Materials.WroughtIron), new GT_MetaPipeEntity_Fluid(5261, "GT_Pipe_WroughtIron_Small", "Small Wrought Iron Fluid Pipe", 0.375F, Materials.WroughtIron, 60, 2250, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(Materials.WroughtIron), new GT_MetaPipeEntity_Fluid(5262, "GT_Pipe_WroughtIron", "Wrought Iron Fluid Pipe", 0.5F, Materials.WroughtIron, 180, 2250, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(Materials.WroughtIron), new GT_MetaPipeEntity_Fluid(5263, "GT_Pipe_WroughtIron_Large", "Large Wrought Iron Fluid Pipe", 0.75F, Materials.WroughtIron, 360, 2250, true).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(Materials.WroughtIron), new GT_MetaPipeEntity_Fluid(5264, "GT_Pipe_WroughtIron_Huge", "Huge Wrought Iron Fluid Pipe", 0.875F, Materials.WroughtIron, 720, 2250, true).getStackForm(1L));*/
		generateFluidPipes(Materials.WroughtIron, Materials.WroughtIron.mName, 5260, 180, 2250, true);
		generateFluidMultiPipes(Materials.WroughtIron, Materials.WroughtIron.mName, 5265, 180, 2250, true);
		generateFluidPipes(GTNH_ExtraMaterials.Weebium, "Weebium2", 18230, 1000000, 10000, true);
		// 5277 - 5588 Free, as of GT 5.09.32.xx
	    // 5589+ Item Pipes Tin
	}

    private static void generateFluidPipes(Materials aMaterial, String name, int startID, int baseCapacity, int heatCapacity, boolean gasProof){
    	generateFluidPipes(aMaterial, name, GT_LanguageManager.i18nPlaceholder ? "%material" : aMaterial.mDefaultLocalName, startID, baseCapacity, heatCapacity, gasProof);
    }

    private static void generateFluidPipes(Materials aMaterial, String name, String displayName, int startID, int baseCapacity, int heatCapacity, boolean gasProof){
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeTiny.get(aMaterial), 	new GT_MetaPipeEntity_Fluid(startID, 		"GT_Pipe_" + name + "_Tiny", 	"Tiny " + displayName + " Fluid Pipe", 	0.25F, 	aMaterial, baseCapacity / 6, 	heatCapacity, gasProof).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeSmall.get(aMaterial), 	new GT_MetaPipeEntity_Fluid(startID + 1, 	"GT_Pipe_" + name + "_Small", 	"Small " + displayName + " Fluid Pipe", 0.375F, aMaterial, baseCapacity / 3, 	heatCapacity, gasProof).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeMedium.get(aMaterial), new GT_MetaPipeEntity_Fluid(startID + 2, 	"GT_Pipe_" + name, 				displayName + " Fluid Pipe", 			0.5F, 	aMaterial, baseCapacity, 		heatCapacity, gasProof).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeLarge.get(aMaterial), 	new GT_MetaPipeEntity_Fluid(startID + 3, 	"GT_Pipe_" + name + "_Large", 	"Large " + displayName + " Fluid Pipe", 0.75F, 	aMaterial, baseCapacity * 2, 	heatCapacity, gasProof).getStackForm(1L));
        GT_OreDictUnificator.registerOre(OrePrefixes.pipeHuge.get(aMaterial), 	new GT_MetaPipeEntity_Fluid(startID + 4, 	"GT_Pipe_" + name + "_Huge", 	"Huge " + displayName + " Fluid Pipe", 	0.875F, 	aMaterial, baseCapacity * 4, 	heatCapacity, gasProof).getStackForm(1L));

    }
	private static void generateFluidMultiPipes(Materials aMaterial, String name, int startID, int baseCapacity, int heatCapacity, boolean gasProof){
		generateFluidMultiPipes(aMaterial, name, GT_LanguageManager.i18nPlaceholder ? "%material" : aMaterial.mDefaultLocalName, startID, baseCapacity, heatCapacity, gasProof);
	}

	private static void generateFluidMultiPipes(Materials aMaterial, String name, String displayName, int startID, int baseCapacity, int heatCapacity, boolean gasProof){
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeQuadruple.get(aMaterial), 	new GT_MetaPipeEntity_Fluid(startID, 		"GT_Pipe_" + name + "_Quadruple", 	"Quadruple " + displayName + " Fluid Pipe", 	1.0F, 	aMaterial, baseCapacity, 	heatCapacity, gasProof, 4).getStackForm(1L));
		GT_OreDictUnificator.registerOre(OrePrefixes.pipeNonuple.get(aMaterial), 	new GT_MetaPipeEntity_Fluid(startID + 1,	"GT_Pipe_" + name + "_Nonuple", 	"Nonuple "	 + displayName + " Fluid Pipe", 	1.0F, 	aMaterial, baseCapacity / 3, 	heatCapacity, gasProof, 9).getStackForm(1L));
	}
}
