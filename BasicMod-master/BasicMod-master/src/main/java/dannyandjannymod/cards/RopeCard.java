package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.stances.SuicidalStance;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class RopeCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "RopeCard",
            0,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int UPG_DAMAGE = 10;
    private static final int DAMAGE = 20;

    public RopeCard() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SMASH));
        addToBot(new ChangeStanceAction(SuicidalStance.STANCE_ID));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new RopeCard();
    }
}