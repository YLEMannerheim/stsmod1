package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.CleaveEffect;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class MilkSplashCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MilkSplashCard",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int UPG_DAMAGE = 3;
    private static final int DAMAGE = 8;

    public MilkSplashCard() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setExhaust(true);
        this.tags.add(CustomTags.MILK);
        cardsToPreview = new EmptyBottleCard();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new SFXAction("ATTACK_HEAVY"));
        this.addToBot(new VFXAction(p, new CleaveEffect(), 0.1F));
        this.addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        this.addToBot(new MakeTempCardInHandAction(new EmptyBottleCard(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MilkSplashCard();
    }
}