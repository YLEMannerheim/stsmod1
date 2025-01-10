package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.defect.EvokeOrbAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.util.CardInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;

import static dannyandjannymod.BasicMod.makeID;

public class OutletCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "OutletCard",
            3,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    public OutletCard() {
        super(cardInfo);
        setDamage(15,5);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int orbCount = p.filledOrbCount();
        for (int i = 0; i < orbCount; i++) {
            addToBot(new EvokeOrbAction(1));
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new OutletCard();
    }
}