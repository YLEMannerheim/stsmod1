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
import com.megacrit.cardcrawl.vfx.combat.IntimidateEffect;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.CardInfo;

import java.util.Iterator;

import static dannyandjannymod.BasicMod.makeID;

public class LongLifeMilkCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "LongLifeMilkCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int UPG_BLOCK = 3;
    private static final int BLOCK = 6;

    public LongLifeMilkCard() {
        super(cardInfo);
        setExhaust(true);
        setSelfRetain(true);
        setBlock(BLOCK, UPG_BLOCK);
        this.tags.add(CustomTags.MILK);
        cardsToPreview = new EmptyBottleCard();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        this.addToBot(new MakeTempCardInHandAction(new EmptyBottleCard(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new LongLifeMilkCard();
    }
}