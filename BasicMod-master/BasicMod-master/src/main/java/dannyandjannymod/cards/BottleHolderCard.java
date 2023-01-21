package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.BottleHolderAction;
import com.megacrit.cardcrawl.actions.unique.ExpertiseAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class BottleHolderCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BottleHolderCard",
            3,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.RARE,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    public BottleHolderCard() {
        super(cardInfo);
        setExhaust(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new BottleHolderAction(p, 10));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(2);
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new BottleHolderCard();
    }
}