package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import dannyandjannymod.powers.CalciumPower;

import static dannyandjannymod.BasicMod.makeID;

public class MechanicalWhiskRelic extends BaseRelic {
    public static final String NAME = "MechanicalWhiskRelic";
    public static final String ID = makeID(NAME);
    public static final int CALC = 2;

    public MechanicalWhiskRelic() {
        super(ID, NAME, RelicTier.RARE, LandingSound.CLINK);
    }

    public void onExhaust(AbstractCard card) {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flash();
            AbstractPlayer p = AbstractDungeon.player;
            this.addToBot(new RelicAboveCreatureAction(p, this));
            addToBot(new ApplyPowerAction(p, p, new CalciumPower(p, CALC), CALC));
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + CALC + DESCRIPTIONS[1];
    }
}