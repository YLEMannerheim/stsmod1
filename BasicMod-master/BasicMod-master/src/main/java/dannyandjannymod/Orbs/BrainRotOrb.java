package dannyandjannymod.orbs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.status.Dazed;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import dannyandjannymod.effects.PusheenOrbPassiveEffect;

import static dannyandjannymod.BasicMod.NYA_KEY;
import static dannyandjannymod.BasicMod.makeID;

public class BrainRotOrb extends AbstractOrb {
    public static final String ORB_ID = makeID("BrainRotOrb");
    private static final OrbStrings orbString;
    private float vfxTimer = 1.0F;
    private static final float PI_DIV_16 = 0.19634955F;
    private static final float ORB_WAVY_DIST = 0.05F;
    private static final float PI_4 = 12.566371F;
    private static final float ORB_BORDER_SCALE = 1.2F;
    private final float vfxIntervalMin = 0.15F;
    private final float vfxIntervalMax = 0.8F;

    public BrainRotOrb() {
        this.ID = ORB_ID;
        this.img = ImageMaster.loadImage("dannyandjannymod/orbs/pusheen.png");
        this.name = orbString.NAME;
        this.baseEvokeAmount = 69;
        this.evokeAmount = this.baseEvokeAmount;
        this.basePassiveAmount = 1;
        this.passiveAmount = this.basePassiveAmount;
        this.updateDescription();
        this.angle = MathUtils.random(360.0F);
        this.channelAnimTimer = 0.5F;
    }

    public void updateDescription() {
        this.applyFocus();
        this.description = orbString.DESCRIPTION[0];
    }

    public void onEvoke() {
        AbstractDungeon.actionManager.addToTop(new DiscardAction(AbstractDungeon.player, AbstractDungeon.player, AbstractDungeon.player.hand.size(), true));
    }

    public void onEndOfTurn() {
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new Dazed(), 1, true, true));
    }

    public AbstractOrb makeCopy() {
        return new BrainRotOrb();
    }

    public void render(SpriteBatch sb) {
        this.shineColor.a = this.c.a / 2.0F;
        sb.setColor(this.shineColor);
        sb.setBlendFunction(770, 1);

        sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F,
                this.scale + MathUtils.sin(this.angle / PI_4) * ORB_WAVY_DIST + PI_DIV_16,
                this.scale * ORB_BORDER_SCALE, this.angle, 0, 0, 96, 96, false, false);

        sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F,
                this.scale * ORB_BORDER_SCALE, this.scale + MathUtils.sin(this.angle / PI_4) * ORB_WAVY_DIST + PI_DIV_16,
                -this.angle, 0, 0, 96, 96, false, false);

        sb.setBlendFunction(770, 771);
        sb.setColor(this.c);
        sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F,
                this.scale, this.scale, this.angle / 12.0F, 0, 0, 96, 96, false, false);

        this.renderText(sb);
        this.hb.render(sb);
    }

    protected void renderText(SpriteBatch sb) {
    }

    public void updateAnimation() {
        super.updateAnimation();
        this.angle += Gdx.graphics.getDeltaTime() * 180.0F;
        this.vfxTimer -= Gdx.graphics.getDeltaTime();
        if (this.vfxTimer < 0.0F) {
            AbstractDungeon.effectList.add(new PusheenOrbPassiveEffect(this.cX, this.cY));
            if (MathUtils.randomBoolean()) {
                AbstractDungeon.effectList.add(new PusheenOrbPassiveEffect(this.cX, this.cY));
            }

            this.vfxTimer = MathUtils.random(this.vfxIntervalMin, this.vfxIntervalMax);
        }
    }

    public void playChannelSFX () {
            CardCrawlGame.sound.playV(NYA_KEY, 0.75f);
        }
        static {
            orbString = CardCrawlGame.languagePack.getOrbString("BrainRotOrb");
        }
    }