package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.vfx.combat.IntimidateEffect;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.CardInfo;

import java.util.Iterator;

import static dannyandjannymod.BasicMod.makeID;

public class MilkSpillCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MilkSpillCard",
            1,
            CardType.SKILL,
            CardTarget.ALL_ENEMY,
            CardRarity.COMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int UPG_MAGIC = 1;
    private static final int MAGIC = 2;

    public MilkSpillCard() {
        super(cardInfo);
        setExhaust(true);
        setMagic(MAGIC, UPG_MAGIC);
        this.tags.add(CustomTags.MILK);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new SFXAction("INTIMIDATE"));
        this.addToBot(new VFXAction(p, new IntimidateEffect(AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY), 1.0F));
        Iterator var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

        while(var3.hasNext()) {
            AbstractMonster mo = (AbstractMonster)var3.next();
            this.addToBot(new ApplyPowerAction(mo, p, new VulnerablePower(mo, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
        }

        this.addToBot(new MakeTempCardInHandAction(new EmptyBottleCard(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MilkSpillCard();
    }
}