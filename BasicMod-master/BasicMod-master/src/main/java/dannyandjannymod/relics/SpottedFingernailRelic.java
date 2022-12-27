package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Wound;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import dannyandjannymod.cards.CalciumDeficiencyCard;

import static dannyandjannymod.BasicMod.makeID;

public class SpottedFingernailRelic extends BaseRelic {
    public static final String NAME = "SpottedFingernailRelic";
    public static final String ID = makeID(NAME);

    public SpottedFingernailRelic() {
        super(ID, NAME, RelicTier.BOSS, LandingSound.MAGICAL);
    }

    public void atBattleStart() {
        this.flash();
        this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        this.addToBot(new MakeTempCardInDrawPileAction(new CalciumDeficiencyCard(), 1, true, true));
    }

    public void onEquip() {
        ++AbstractDungeon.player.energy.energyMaster;
    }

    public void onUnequip() {
        --AbstractDungeon.player.energy.energyMaster;
    }


    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + "" + DESCRIPTIONS[1]; // TODO
    }
}