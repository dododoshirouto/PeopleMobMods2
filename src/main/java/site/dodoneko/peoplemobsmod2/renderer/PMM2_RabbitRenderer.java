package site.dodoneko.peoplemobsmod2.renderer;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.Util;

import net.minecraft.client.model.RabbitModel;
import net.minecraft.client.renderer.entity.RabbitRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import site.dodoneko.peoplemobsmod2.PeopleMobsMod2;
import site.dodoneko.peoplemobsmod2.base.PMM2_HumanoidMobRenderer;
import site.dodoneko.peoplemobsmod2.base.PMM2_HumanoidModel;

@OnlyIn(Dist.CLIENT)
public class PMM2_RabbitRenderer<T extends Rabbit> extends PMM2_HumanoidMobRenderer<T, PMM2_HumanoidModel<T>> {

    RabbitRenderer refR;
    RabbitModel<Rabbit> refM;
    
    public static float modelScale = 0.9F;
    public static float bHeight = 0.3F;
    public static void setModelScales(float scale, float height) {
        modelScale = scale;
        bHeight = height;
    }

    @SuppressWarnings("null")
    private static final Map<Rabbit.Variant, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(),
            (entity) -> {
                entity.put(Rabbit.Variant.BROWN, new ResourceLocation("textures/entity/rabbit/brown-chan.png"));
                entity.put(Rabbit.Variant.WHITE, new ResourceLocation("textures/entity/rabbit/white-chan.png"));
                entity.put(Rabbit.Variant.BLACK, new ResourceLocation("textures/entity/rabbit/black-chan.png"));
                entity.put(Rabbit.Variant.GOLD, new ResourceLocation("textures/entity/rabbit/gold-chan.png"));
                entity.put(Rabbit.Variant.SALT, new ResourceLocation("textures/entity/rabbit/salt-chan.png"));
                entity.put(Rabbit.Variant.WHITE_SPLOTCHED, new ResourceLocation("textures/entity/rabbit/white_splotched-chan.png"));
                // entity.put(Rabbit.Variant.TOAST, new ResourceLocation("textures/entity/rabbit/toast-chan.png"));
                entity.put(Rabbit.Variant.EVIL, new ResourceLocation("textures/entity/rabbit/caerbannog-chan.png"));
            });

    @SuppressWarnings("null")
    public PMM2_RabbitRenderer(EntityRendererProvider.Context entity) {
        super(entity, new PMM2_HumanoidModel<>(entity.bakeLayer(PeopleMobsMod2.PMM2_HUMANOID_LAYER)), modelScale);
        this.getModel().bHeight = bHeight;
        this.getModel().useChildModel = isChildModel;
        this.getModel().flyFlap = doFlyFlap;
    }
    public static boolean isChildModel = false;
    public static boolean doFlyFlap = false;
    public static void setModelScales(float scale, float height, boolean isChild) {
        modelScale = scale;
        bHeight = height;
        isChildModel = isChild;
    }
    public static void setModelScales(float scale, float height, boolean isChild, boolean flyFlap) {
        modelScale = scale;
        bHeight = height;
        isChildModel = isChild;
        doFlyFlap = flyFlap;
    }

    @Override
    public ResourceLocation getTextureLocation(Rabbit entity) {
        return TEXTURES.get(entity.getVariant());
    }
}