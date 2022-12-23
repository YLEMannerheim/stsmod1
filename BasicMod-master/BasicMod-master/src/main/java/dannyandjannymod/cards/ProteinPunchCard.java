package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import dannyandjannymod.powers.CalciumPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class ProteinPunchCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ProteinPunchCard",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 5;
    public static final int UPG_MAGIC = 5;
    public static final int DAMAGE = 0;

    public ProteinPunchCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
        setDamage(DAMAGE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int calcAmt = 0;
        if (p.getPower("CalciumPower") != null) {
            calcAmt = p.getPower("CalciumPower").amount;
        }
        int dmgToDeal = this.damage + (calcAmt * this.magicNumber);
        addToBot(new DamageAction(m, new DamageInfo(p, dmgToDeal, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HEAVY));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ProteinPunchCard();
    }
}