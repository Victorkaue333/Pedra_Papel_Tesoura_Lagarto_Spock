# Pedra, Papel, Tesoura, Lagarto, Spock 🖖

Implementação do clássico jogo "Pedra, Papel, Tesoura, Lagarto, Spock", popularizado pela série **The Big Bang Theory**.

## 📝 Descrição

Este projeto contém implementações do jogo em  **Java**, onde o jogador compete contra o computador em rodadas sucessivas. O jogo segue as regras expandidas que adicionam "Lagarto" e "Spock" às opções tradicionais.

## 🎮 Regras do Jogo

Cada opção vence contra duas outras:

- ✂️ **Tesoura** corta Papel e decapita Lagarto
- 📄 **Papel** cobre Pedra e refuta Spock
- 🪨 **Pedra** esmaga Lagarto e quebra Tesoura
- 🦎 **Lagarto** envenena Spock e come Papel
- 🖖 **Spock** esmaga Tesoura e vaporiza Pedra

## 🚀 Como Executar

### Versão Java

**Compilar:**
```bat
javac PedraPapelTesouraLagartoSpock.java
```

**Executar:**
```bat
java PedraPapelTesouraLagartoSpock
```


## ✨ Funcionalidades

- ✅ Loop de jogo com múltiplas rodadas
- ✅ Validação de entrada (insensível a maiúsculas/minúsculas)
- ✅ Escolha aleatória do computador
- ✅ Mensagens explicativas para cada resultado
- ✅ Sistema de placar (vitórias, derrotas e empates)
- ✅ Opção de jogar novamente ou encerrar

## 🎯 Como Jogar

1. Execute o programa
2. Digite sua escolha: **Pedra**, **Papel**, **Tesoura**, **Lagarto** ou **Spock**
3. Veja o resultado da rodada e o placar atualizado
4. Escolha **S** para jogar novamente ou **N** para encerrar
5. Ao final, o placar completo é exibido

## 📊 Exemplo de Execução

```
--- Pedra, Papel, Tesoura, Lagarto, Spock ---
Escolha (Pedra/Papel/Tesoura/Lagarto/Spock): spock

Você escolheu: Spock
Computador escolheu: Tesoura

Spock esmaga Tesoura
Você venceu!

Placar: Você 1 — Computador 0 — Empates 0

Jogar novamente? (S/N): s
```

## 🛠️ Requisitos

### Java
- JDK 8 ou superior

## 📄 Licença

Este projeto é de código aberto e está disponível para uso educacional.

## 👨‍💻 Autor

Desenvolvido como projeto educacional para demonstrar conceitos de programação em Java.

