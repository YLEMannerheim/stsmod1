package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class JamesCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "JamesCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int STRENGTH = 1;

    public JamesCard() {
        super(cardInfo);
        setMagic(1,1);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (AbstractCard card : p.hand.group) {
            if (card.cardID.equals(MilkmanStrikeCard.ID)) {
                addToBot(new DiscardSpecificCardAction(card));
            }
        }
        this.addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, STRENGTH), STRENGTH));
        this.addToBot(new DrawCardAction(magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new JamesCard();
    }
}