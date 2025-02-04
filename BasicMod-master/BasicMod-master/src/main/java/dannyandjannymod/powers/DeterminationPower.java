package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.purple.Foresight;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.watcher.ForesightPower;
import com.megacrit.cardcrawl.vfx.BorderFlashEffect;
import com.megacrit.cardcrawl.vfx.combat.GiantEyeEffect;
import dannyandjannymod.cards.ChugCard;
import dannyandjannymod.stances.TiltedStance;
import dannyandjannymod.util.TextureLoader;

import static dannyandjannymod.BasicMod.makeID;

public class DeterminationPower extends BasePower {
    public static final String POWER_ID = makeID("DeterminationPower");
    public static final PowerType POWER_TYPE = PowerType.BUFF;
    public static final boolean IS_TURN_BASED = false;

    public DeterminationPower(AbstractCreature owner) {
        super(POWER_ID, POWER_TYPE, IS_TURN_BASED, owner, -1);
    }

    @Override
    public float atDamageFinalGive(float damage, DamageInfo.DamageType type) {
        // Check if the player is currently in Tilted stance
        if (AbstractDungeon.player.stance.ID.equals(TiltedStance.STANCE_ID)) {
            return damage * 2.0F;
        }
        return damage;
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}