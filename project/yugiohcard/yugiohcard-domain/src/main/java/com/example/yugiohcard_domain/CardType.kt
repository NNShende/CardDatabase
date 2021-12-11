@file:Suppress("unused")
package com.example.yugiohcard_domain

enum class CardType(name: String) {
    EffectMonster(name = "Effect Monster"),
    FlipEffectMonster(name = "Flip Effect Monster"),
    FlipTunerEffectMonster(name = "Flip Tuner Effect Monster"),
    GeminiMonster(name = "Gemini Monster"),
    NormalMonster(name = "Normal Monster"),
    NormalTunerMonster(name = "Normal Tuner Monster"),
    PendulumEffectMonster(name = "Pendulum Effect Monster"),
    PendulumFlipEffectMonster(name = "Pendulum Flip Effect Monster"),
    PendulumNormalMonster(name = "Pendulum Normal Monster"),
    PendulumTunerEffectMonster(name = "Pendulum Tuner Effect Monster"),
    RitualEffectMonster(name = "Ritual Effect Monster"),
    RitualMonster(name = "Ritual Monster"),
    SkillCard(name = "Skill Card"),
    SpellCard(name = "Spell Card"), // Not a monster
    SpiritMonster(name = "Spirit Monster"),
    ToonMonster(name = "Toon Monster"),
    TrapCard(name = "Trap Card"), // Not a monster
    TunerMonster(name = "Tuner Monster"),
    UnionEffectMonster(name = "Union Effect Monster"),
    FusionMonster(name = "Fusion Monster"),
    LinkMonster(name = "Link Monster"),
    PendulumEffectFusionMonster(name = "Pendulum Effect Fusion Monster"),
    SynchroMonster(name = "Synchro Monster"),
    SynchroPendulumEffectMonster(name = "Synchro Pendulum Effect Monster"),
    SynchroTunerMonster(name = "Synchro Tuner Monster"),
    XYZMonster(name = "XYZ Monster"),
    XYZPendulumEffectMonster(name = "XYZ Pendulum Effect Monster"),

    Unknown("unknown"),
}

// TODO(Fix this)
fun getCardType(name: String): CardType {
    val values = CardType.values().toList()

    val foundType = values.find { it.name == name } ?: CardType.Unknown
    return foundType
}
