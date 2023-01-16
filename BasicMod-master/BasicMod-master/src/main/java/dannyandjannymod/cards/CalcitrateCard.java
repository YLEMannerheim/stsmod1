package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class CalcitrateCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "CalcitrateCard",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int DAMAGE = 8;
    public static final int UPG_DAMAGE = 4;

    public CalcitrateCard() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        /*
        int calcAmt = 0;
        if (p.getPower("CalciumPower") != null) {
            calcAmt = p.getPower("CalciumPower").amount;
        }
        int dmgToDeal = this.damage + (calcAmt * this.magicNumber);
        addToBot(new DamageAction(m, new DamageInfo(p, dmgToDeal, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HEAVY));
        */

        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HEAVY));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new CalcitrateCard();
    }
}