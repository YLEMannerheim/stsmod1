package dannyandjannymod.orbs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;
import com.megacrit.cardcrawl.vfx.combat.OrbFlareEffect;
import dannyandjannymod.effects.PusheenOrbPassiveEffect;
import dannyandjannymod.stances.AfkStance;
import dannyandjannymod.stances.SuicidalStance;

import java.util.Collections;

import static dannyandjannymod.BasicMod.NYA_KEY;
import static dannyandjannymod.BasicMod.makeID;

public class KidOrb extends AbstractOrb {
    public static final String ORB_ID = makeID("KidOrb");
    private static final OrbStrings orbString;
    private float vfxTimer = 1.0F;
    private static final float PI_DIV_16 = 0.19634955F;
    private static final float ORB_WAVY_DIST = 0.05F;
    private static final float PI_4 = 12.566371F;
    private static final float ORB_BORDER_SCALE = 1.2F;
    private static final int CARDS_TO_PLAY = 18;
    private final float vfxIntervalMin = 0.15F;
    private final float vfxIntervalMax = 0.8F;

    public KidOrb() {
        this.ID = ORB_ID;
        this.img = ImageMaster.loadImage("dannyandjannymod/orbs/kid.png");
        this.name = orbString.NAME;
        this.baseEvokeAmount = 0;
        this.evokeAmount = this.baseEvokeAmount;
        this.basePassiveAmount = 0;
        this.passiveAmount = this.basePassiveAmount;
        this.updateDescription();
        this.angle = MathUtils.random(360.0F);
        this.channelAnimTimer = 0.5F;
    }

    public void updateDescription() {
        this.applyFocus();
        this.description = orbString.DESCRIPTION[0] + CARDS_TO_PLAY + orbString.DESCRIPTION[1];
    }

    public void onPlayCard() {
        float speedTime = Settings.FAST_MODE ? 0F : 0.6F / (float)AbstractDungeon.player.orbs.size();
        AbstractDungeon.actionManager.addToBottom(new VFXAction(new OrbFlareEffect(this, OrbFlareEffect.OrbFlareColor.DARK), speedTime));
        passiveAmount++;

        AbstractPlayer p = AbstractDungeon.player;
        if (passiveAmount >= 18) {
            for (int i = 0; i < p.orbs.size(); i++) {
                if (p.orbs.get(i) == this) {
                    int j;
                    for(j = i; j < p.orbs.size(); ++j) {
                        Collections.swap(p.orbs, j, j - 1); // this is crashing
                    }

                    for(j = i; j < p.orbs.size(); ++j) {
                        ((AbstractOrb)p.orbs.get(j)).setSlot(j, p.maxOrbs);
                    }
                }
            }
        } else
            updateDescription();
    }

    @Override
    public void applyFocus() {
    }

    public void onEvoke() {
        AbstractDungeon.actionManager.addToBottom(new ChangeStanceAction(SuicidalStance.STANCE_ID));
    }

    public void onEndOfTurn() {
    }

    public AbstractOrb makeCopy() {
        return new KidOrb();
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

    protected void renderText(SpriteBatch sb) {
        FontHelper.renderFontCentered(sb, FontHelper.cardEnergyFont_L, Integer.toString(this.evokeAmount), this.cX + NUM_X_OFFSET, this.cY + this.bobEffect.y / 2.0F + NUM_Y_OFFSET - 4.0F * Settings.scale, new Color(0.2F, 1.0F, 1.0F, this.c.a), this.fontScale);
        FontHelper.renderFontCentered(sb, FontHelper.cardEnergyFont_L, Integer.toString(this.passiveAmount), this.cX + NUM_X_OFFSET, this.cY + this.bobEffect.y / 2.0F + NUM_Y_OFFSET + 20.0F * Settings.scale, this.c, this.fontScale);
    }


    public void playChannelSFX () {
            CardCrawlGame.sound.playV(NYA_KEY, 0.75f);
        }
        static {
            orbString = CardCrawlGame.languagePack.getOrbString("KidOrb");
        }
    }