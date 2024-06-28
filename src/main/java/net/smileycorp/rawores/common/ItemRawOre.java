package net.smileycorp.rawores.common;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.smileycorp.atlas.api.util.TextUtils;

public class ItemRawOre extends Item {
    
    private final OreEntry entry;
    
    public ItemRawOre(OreEntry entry) {
        this.entry = entry;
        String name = "Raw_" + TextUtils.toProperCase(entry.getName());
        setRegistryName(Constants.loc(name));
        setUnlocalizedName(Constants.name(name));
        setCreativeTab(RawOres.CREATIVE_TAB);
    }
    
    public OreEntry getEntry() {
        return entry;
    }
    
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return I18n.translateToLocalFormatted("items.raw_ores.RawOre.name", entry.getOres().get(0).getDisplayName().replace("Ore", "").trim()).trim();
    }
    
}