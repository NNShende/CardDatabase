@file:Suppress("unused")
package com.example.yugiohcard_domain

enum class CardType(val typeName: String) {
    EffectMonster(typeName = "Effect Monster"),
    FlipEffectMonster(typeName = "Flip Effect Monster"),
    FlipTunerEffectMonster(typeName = "Flip Tuner Effect Monster"),
    GeminiMonster(typeName = "Gemini Monster"),
    NormalMonster(typeName = "Normal Monster"),
    NormalTunerMonster(typeName = "Normal Tuner Monster"),
    PendulumEffectMonster(typeName = "Pendulum Effect Monster"),
    PendulumFlipEffectMonster(typeName = "Pendulum Flip Effect Monster"),
    PendulumNormalMonster(typeName = "Pendulum Normal Monster"),
    PendulumTunerEffectMonster(typeName = "Pendulum Tuner Effect Monster"),
    RitualEffectMonster(typeName = "Ritual Effect Monster"),
    RitualMonster(typeName = "Ritual Monster"),
    SkillCard(typeName = "Skill Card"),
    SpellCard(typeName = "Spell Card"), // Not a monster
    SpiritMonster(typeName = "Spirit Monster"),
    ToonMonster(typeName = "Toon Monster"),
    TrapCard(typeName = "Trap Card"), // Not a monster
    TunerMonster(typeName = "Tuner Monster"),
    UnionEffectMonster(typeName = "Union Effect Monster"),
    FusionMonster(typeName = "Fusion Monster"),
    LinkMonster(typeName = "Link Monster"),
    PendulumEffectFusionMonster(typeName = "Pendulum Effect Fusion Monster"),
    SynchroMonster(typeName = "Synchro Monster"),
    SynchroPendulumEffectMonster(typeName = "Synchro Pendulum Effect Monster"),
    SynchroTunerMonster(typeName = "Synchro Tuner Monster"),
    XYZMonster(typeName = "XYZ Monster"),
    XYZPendulumEffectMonster(typeName = "XYZ Pendulum Effect Monster"),

    Unknown("unknown"),
}

// TODO(Fix this)
fun getCardType(type: String): CardType {
    val values = CardType.values().toList()

    return values.find { it.typeName == type } ?: CardType.Unknown
}
