package site.dodoneko.peoplemobsmod2.renderer;

import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.renderer.entity.ChickenRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import site.dodoneko.peoplemobsmod2.PeopleMobsMod2;
import site.dodoneko.peoplemobsmod2.base.PMM2_HumanoidMobRenderer;
import site.dodoneko.peoplemobsmod2.base.PMM2_HumanoidModel;

@OnlyIn(Dist.CLIENT)
public class PMM2_ChickenRenderer<T extends Chicken> extends PMM2_HumanoidMobRenderer<T, PMM2_HumanoidModel<T>> {

    ChickenRenderer refR;
    ChickenModel<Chicken> refM;
    
    public static float modelScale = 0.9F;
    public static float bHeight = 0.3F;
    public static void setModelScales(float scale, float height) {
        modelScale = scale;
        bHeight = height;
    }

    @SuppressWarnings("null")
    public PMM2_ChickenRenderer(EntityRendererProvider.Context entity) {
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

    

   @SuppressWarnings("null")
protected float getBob(T p_114000_, float p_114001_) {
      float f = Mth.lerp(p_114001_, p_114000_.oFlap, p_114000_.flap);
      float f1 = Mth.lerp(p_114001_, p_114000_.oFlapSpeed, p_114000_.flapSpeed);
      return (Mth.sin(f) + 1.0F) * f1;
   }
}