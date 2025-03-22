package medievalconclave.medievalconclave.api.tags;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;

import net.minecraft.tags.ItemTags;

public class ModItemTags {

    public static final ITag.INamedTag<Item> DISSUADER = ItemTags.bind(SpartanWeaponryAPI.MOD_ID + ":longswords");
}
