package medievalconclave.medievalconclave.events;


import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.entity.LivingEntity;

public class DamageTrackingHandler {
    public static void register() {
        MinecraftForge.EVENT_BUS.register(new DamageTrackingHandler());
    }

    @SubscribeEvent
    public void onEntityHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        if (!entity.level().isClientSide) {
            CompoundTag data = entity.getPersistentData();
            long currentTick = entity.level().getGameTime();

            data.putFloat("RawDamage", event.getAmount());
            data.putLong("RawDamageTime", currentTick); // store when the damage occurred
        }
    }
}