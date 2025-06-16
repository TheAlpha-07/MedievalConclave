package medievalconclave.medievalconclave.item;

import medievalconclave.medievalconclave.MedievalConclave;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MedievalConclave.MOD_ID);

//    public static final RegistryObject<SwordBaseItem> DISSUADER = ITEMS.register("dissuader",
//            () -> new Dissuader(new Item.Properties().durability(-1), WeaponMaterial.DIAMOND, 4.5F, 1.5F, 1.399999976158142, "item.medievalconclave.dissuader", false, new WeaponTrait[] {WeaponTraits.TWO_HANDED_1, WeaponTraits.SWEEP_DAMAGE_NORMAL}));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
