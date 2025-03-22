package medievalconclave.medievalconclave.enchantment;

import medievalconclave.medievalconclave.MedievalConclave;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MedievalConclave.MOD_ID);

    public static RegistryObject<Enchantment> KENSHI =
            ENCHANTMENTS.register("kenshi_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> SOHEI =
            ENCHANTMENTS.register("sohei_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> YUMIHIKI =
            ENCHANTMENTS.register("yumihiki_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> RONIN =
            ENCHANTMENTS.register("ronin_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> BRUTE =
            ENCHANTMENTS.register("brute_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> HOPLITE =
            ENCHANTMENTS.register("hoplite_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> HIPPEIS =
            ENCHANTMENTS.register("hippeis_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> MISTHIOS =
            ENCHANTMENTS.register("misthios_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> GUARDIAN =
            ENCHANTMENTS.register("guardian_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> MARKSMAN =
            ENCHANTMENTS.register("marksman_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> LONGSWORD =
            ENCHANTMENTS.register("longsword_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> GREATSWORD =
            ENCHANTMENTS.register("greatsword_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

    public static RegistryObject<Enchantment> MAGE =
            ENCHANTMENTS.register("mage_enchantment",
                    () -> new ConditionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
