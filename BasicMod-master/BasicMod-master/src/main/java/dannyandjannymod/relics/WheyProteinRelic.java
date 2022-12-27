package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;

import static dannyandjannymod.BasicMod.makeID;

public class WheyProteinRelic extends BaseRelic {
    public static final String NAME = "WheyProteinRelic";
    public static final String ID = makeID(NAME);

    public WheyProteinRelic() {
        super(ID, NAME, RelicTier.RARE, LandingSound.HEAVY);
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        ++this.counter;
        if (this.counter == 10) {
            this.counter = 0;
            this.flash();
            this.pulse = false;
            AbstractPlayer p = AbstractDungeon.player;
            this.addToBot(new RelicAboveCreatureAction(p, this));
            this.addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, 1), 1));
            this.addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, 1), 1));
        } else if (this.counter == 9) {
            this.beginPulse();
            this.pulse = true;
        }

    }

    public void atBattleStart() {
        if (this.counter == 9) {
            this.beginPulse();
            this.pulse = true;
        }

    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + 1 + DESCRIPTIONS[1];
    }
}