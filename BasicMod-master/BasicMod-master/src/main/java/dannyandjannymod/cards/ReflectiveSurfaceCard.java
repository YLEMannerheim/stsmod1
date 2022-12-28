package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.unique.DoubleYourBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.RegenPower;
import dannyandjannymod.ReflectiveSurfaceAction;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class ReflectiveSurfaceCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ReflectiveSurfaceCard",
            1,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);


    public ReflectiveSurfaceCard() {
        super(cardInfo);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m.currentBlock < 1)
            this.addToBot(new DoubleYourBlockAction(p));
        else
            this.addToBot(new ReflectiveSurfaceAction(p, m));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(0);
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ReflectiveSurfaceCard();
    }
}