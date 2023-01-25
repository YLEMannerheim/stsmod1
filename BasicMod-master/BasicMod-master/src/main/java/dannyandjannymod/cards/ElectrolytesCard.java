package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ReduceCostAction;
import com.megacrit.cardcrawl.actions.common.ReduceCostForTurnAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BerserkPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.DentedBucketAction;
import dannyandjannymod.ElectrolytesAction;
import dannyandjannymod.util.CardInfo;
import sun.security.util.Debug;

import java.util.logging.Logger;

import static dannyandjannymod.BasicMod.makeID;

public class ElectrolytesCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ElectrolytesCard",
            5,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.RARE,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);
    public boolean initialised = false;

    private static final int MAGIC = 1;

    public ElectrolytesCard() {
        super(cardInfo);
        setMagic(MAGIC);
        Debug d = new Debug();
        d.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ Electrolytes misc value is: " + this.misc + "\n");
        //this.updateCost(- this.misc);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new BerserkPower(p, 1), 1));
        addToBot(new ElectrolytesAction(this, this.magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ElectrolytesCard();
    }
}