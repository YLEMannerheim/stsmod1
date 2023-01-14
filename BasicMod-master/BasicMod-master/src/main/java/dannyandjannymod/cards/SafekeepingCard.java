package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.RemoveAllBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class SafekeepingCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SafekeepingCard",
            0,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    public SafekeepingCard() {
        super(cardInfo);
        setSelfRetain(false, true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int blockAmount = p.currentBlock;
        if (blockAmount > 0) {
            this.addToBot(new RemoveAllBlockAction(p, p));
            this.addToBot(new ApplyPowerAction(p, p, new NextTurnBlockPower(p, blockAmount), blockAmount));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SafekeepingCard();
    }
}