package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.ThornsPower;
import dannyandjannymod.cards.CalciumDeficiencyCard;

import static dannyandjannymod.BasicMod.makeID;

public class ButterKnifeRelic extends BaseRelic {
    public static final String NAME = "ButterKnifeRelic";
    public static final String ID = makeID(NAME);
    public static final int THORNS_AMT = 5;

    public ButterKnifeRelic() {
        super(ID, NAME, RelicTier.SHOP, LandingSound.MAGICAL);
    }

    public void atBattleStart() {
        if (AbstractDungeon.getCurrRoom().eliteTrigger) {
            this.flash();
            this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));

            AbstractPlayer p = AbstractDungeon.player;
            this.addToBot(new ApplyPowerAction(p, p, new ThornsPower(p, THORNS_AMT), THORNS_AMT));
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + "" + DESCRIPTIONS[1]; // TODO
    }
}