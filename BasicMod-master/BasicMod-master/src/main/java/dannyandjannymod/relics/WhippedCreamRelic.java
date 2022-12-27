package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;

import static dannyandjannymod.BasicMod.makeID;

public class WhippedCreamRelic extends BaseRelic {
    public static final String NAME = "WhippedCreamRelic";
    public static final String ID = makeID(NAME);
    public static final int CARD_REQUIREMENT = 4;
    public static final int ENERGY_GAIN = 1;

    public WhippedCreamRelic() {
        super(ID, NAME, RelicTier.BOSS, LandingSound.MAGICAL);
    }

    @Override
    public void atTurnStart() {
        counter = 0;
    }

    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        counter++;
        if (counter == CARD_REQUIREMENT) {
            flash();
            this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));

            AbstractPlayer p = AbstractDungeon.player;
            this.addToBot(new ApplyPowerAction(p, p, new EnergizedPower(p, ENERGY_GAIN), ENERGY_GAIN));
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + CARD_REQUIREMENT + DESCRIPTIONS[1] + ENERGY_GAIN; // TODO
    }
}