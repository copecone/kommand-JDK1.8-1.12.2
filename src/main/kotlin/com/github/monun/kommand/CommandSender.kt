/*
 * Copyright (c) 2020 Noonmaru
 *
 *  Licensed under the General Public License, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/gpl-3.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.monun.kommand

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.TextComponent
import net.md_5.bungee.api.chat.BaseComponent
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

fun CommandSender.sendFeedback(message: () -> ComponentLike) {
    if (this is Player) {
        world.getGameRuleValue("sendCommandFeedback")?.let { r ->
            val condition = when (r) {
                "true" -> {
                    true
                }
                "false" -> {
                    false
                }
                else -> {
                    false
                }
            }

            if (!condition)
                return
        }
    }

    sendMessage(Component.join(message.invoke().asComponent()).content())
}

fun CommandSender.sendFeedback(message: String) {
    if (this is Player) {
        world.getGameRuleValue("sendCommandFeedback")?.let { r ->
            val condition = when (r) {
                "true" -> {
                    true
                }
                "false" -> {
                    false
                }
                else -> {
                    false
                }
            }

            if (!condition)
                return
        }
    }

    sendMessage(message)
}