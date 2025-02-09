package site.dodoneko.peoplemobsmod2.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.util.Mth;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.GlowSquid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import site.dodoneko.peoplemobsmod2.PeopleMobsMod2;
import site.dodoneko.peoplemobsmod2.base.PMM2_HumanoidMobRenderer;
import site.dodoneko.peoplemobsmod2.base.PMM2_HumanoidModel;

/**
 * @see net.minecraft.client.model.SquidModel
 * @see net.minecraft.client.renderer.entity.GlowSquidRenderer
 */
@OnlyIn(Dist.CLIENT)
public class PMM2_GlowSquidRenderer extends PMM2_HumanoidMobRenderer<GlowSquid, PMM2_HumanoidModel<GlowSquid>> {

    // model options
    public static float modelScale = 0.9F;
    public static float bHeight = 0.3F;
    public static boolean useChildModel = false;
    public static boolean doFlyFlap = false;
    public static boolean forwardArm = false;
    public static boolean isFloating = false;
    public static float floatingHeight = 0.0F;
    public static boolean doWalkBounding = true;

    public PMM2_GlowSquidRenderer(EntityRendererProvider.Context entity) {
        super(entity, new PMM2_HumanoidModel<>(entity.bakeLayer(PeopleMobsMod2.PMM2_TWINKLED_HUMANOID_LAYER)),
                modelScale);
    }

    @SuppressWarnings("null")
    protected void setupRotations(GlowSquid entity, PoseStack matrix, float p1, float p2, float p3) {
        float f = Mth.lerp(p3, entity.xBodyRotO, entity.xBodyRot);
        float f1 = Mth.lerp(p3, entity.zBodyRotO, entity.zBodyRot);
        matrix.translate(0.0F, 0.5F, 0.0F);
        matrix.mulPose(Axis.YP.rotationDegrees(180.0F - p2));
        matrix.mulPose(Axis.XP.rotationDegrees(f));
        matrix.mulPose(Axis.YP.rotationDegrees(f1));
        matrix.translate(0.0F, -0.5F, -0.1F);
    }

    @SuppressWarnings("null")
    protected float getBob(GlowSquid entity, float partialTick) {
        return Mth.lerp(partialTick, entity.oldTentacleAngle, entity.tentacleAngle);
    }

    @SuppressWarnings("null")
    protected int getBlockLightLevel(GlowSquid entity, BlockPos blockPos) {
        int i = (int) Mth.clampedLerp(0.0F, 15.0F, 1.0F - (float) entity.getDarkTicksRemaining() / 10.0F);
        return i == 15 ? 15 : Math.max(i, super.getBlockLightLevel(entity, blockPos));
    }
}