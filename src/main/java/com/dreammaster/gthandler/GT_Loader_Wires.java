package com.dreammaster.gthandler;

import gregtech.GT_Mod;
import gregtech.api.enums.GTNH_ExtraMaterials;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.metatileentity.implementations.GT_MetaPipeEntity_Cable;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_OreDictUnificator;

public class GT_Loader_Wires 
{
	public void run()
	{
		registerWires();
	}
	
    private void registerWires()
    {

        boolean bEC = !GT_Mod.gregtechproxy.mHardcoreCables;
    	// ID Range: 1200 - 4100
    	// Free IDs: 2030 - 4100
    	


        // ===================================================================================================
        // Make wires
        // ===================================================================================================

        //Takes 20!!! slots per wire
        makeWires(Materials.ElectrumFlux, 1900, 1L, 2L, 3L, GT_Values.V[8], true, false);
        makeWires(Materials.Bedrockium, 11310, bEC ? 1L : 16L, bEC ? 32L : 64L, 2L, GT_Values.V[9], true, false);
        makeWires(Materials.Draconium, 11330, bEC ? 4L : 16L, bEC ? 32L : 64L, 8L, GT_Values.V[10], true, false);
        makeWires(Materials.NetherStar, 11350, bEC ? 4L : 16L, bEC ? 16L : 32L, 4L, GT_Values.V[11], true, false);
        makeWires(Materials.Quantium, 11370, bEC ? 4L : 16L, bEC ? 16L : 32L, 2L, GT_Values.V[12], false, false);
        makeWires(Materials.BlackPlutonium, 11390, bEC ? 4L : 16L, bEC ? 16L : 32L, 1L, GT_Values.V[13], false, false);
        makeWires(Materials.DraconiumAwakened, 11410, bEC ? 4L : 16L, bEC ? 16L : 32L, 1L, GT_Values.V[14], false, false);
        makeWires(Materials.Infinity, 11430, 1L, 1L, 16L, GT_Values.V[15], false, true);
        makeWires(GTNH_ExtraMaterials.Weebium, 18100, 1L, 2L, 16L, GT_Values.V[8], true, false);

        /** ID SPACE RESERVED: to 11800, FOR WIRES
        makeWires(Materials.???, 1920, 4L, 8L, 8L, gregtech.api.enums.GT_Values.V[8], true, false);
        2000 and 2010 are used for RedAlloy and Super Conductor **/
    }
    
    private static void makeWires(Materials aMaterial, int aStartID, long aLossInsulated, long aLoss, long aAmperage, long aVoltage, boolean aInsulatable, boolean aAutoInsulated)
    {
      String displayName = GT_LanguageManager.i18nPlaceholder ? "%material" : aMaterial.mDefaultLocalName;
      GT_OreDictUnificator.registerOre(OrePrefixes.wireGt01, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 0, "wire." + aMaterial.mName.toLowerCase() + ".01", "1x " + displayName + " Wire", 0.125F, aMaterial, aLoss, 1L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
      GT_OreDictUnificator.registerOre(OrePrefixes.wireGt02, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 1, "wire." + aMaterial.mName.toLowerCase() + ".02", "2x " + displayName + " Wire", 0.25F, aMaterial, aLoss, 2L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
      GT_OreDictUnificator.registerOre(OrePrefixes.wireGt04, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 2, "wire." + aMaterial.mName.toLowerCase() + ".04", "4x " + displayName + " Wire", 0.375F, aMaterial, aLoss, 4L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
      GT_OreDictUnificator.registerOre(OrePrefixes.wireGt08, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 3, "wire." + aMaterial.mName.toLowerCase() + ".08", "8x " + displayName + " Wire", 0.5F, aMaterial, aLoss, 8L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
      GT_OreDictUnificator.registerOre(OrePrefixes.wireGt12, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 4, "wire." + aMaterial.mName.toLowerCase() + ".12", "12x " + displayName + " Wire", 0.625F, aMaterial, aLoss, 12L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
      GT_OreDictUnificator.registerOre(OrePrefixes.wireGt16, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 5, "wire." + aMaterial.mName.toLowerCase() + ".16", "16x " + displayName + " Wire", 0.75F, aMaterial, aLoss, 16L * aAmperage, aVoltage, false, !aAutoInsulated).getStackForm(1L));
      if (aInsulatable)
      {
          GT_OreDictUnificator.registerOre(OrePrefixes.cableGt01, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 6, "cable." + aMaterial.mName.toLowerCase() + ".01", "1x " + displayName + " Cable", 0.25F, aMaterial, aLossInsulated, 1L * aAmperage, aVoltage, true, false).getStackForm(1L));
          GT_OreDictUnificator.registerOre(OrePrefixes.cableGt02, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 7, "cable." + aMaterial.mName.toLowerCase() + ".02", "2x " + displayName + " Cable", 0.375F, aMaterial, aLossInsulated, 2L * aAmperage, aVoltage, true, false).getStackForm(1L));
          GT_OreDictUnificator.registerOre(OrePrefixes.cableGt04, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 8, "cable." + aMaterial.mName.toLowerCase() + ".04", "4x " + displayName + " Cable", 0.5F, aMaterial, aLossInsulated, 4L * aAmperage, aVoltage, true, false).getStackForm(1L));
          GT_OreDictUnificator.registerOre(OrePrefixes.cableGt08, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 9, "cable." + aMaterial.mName.toLowerCase() + ".08", "8x " + displayName + " Cable", 0.625F, aMaterial, aLossInsulated, 8L * aAmperage, aVoltage, true, false).getStackForm(1L));
          GT_OreDictUnificator.registerOre(OrePrefixes.cableGt12, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 10, "cable." + aMaterial.mName.toLowerCase() + ".12", "12x " + displayName + " Cable", 0.75F, aMaterial, aLossInsulated, 12L * aAmperage, aVoltage, true, false).getStackForm(1L));
          GT_OreDictUnificator.registerOre(OrePrefixes.cableGt16, aMaterial, new GT_MetaPipeEntity_Cable(aStartID + 11, "cable." + aMaterial.mName.toLowerCase() + ".16", "16x " + displayName + " Cable", 0.875F, aMaterial, aLossInsulated, 16L * aAmperage, aVoltage, true, false).getStackForm(1L));      }
    }
}