# L04-UNO

## Overview
We're building UNO this week! At least a text based card game inspired by UNO.

## Objectives
- Implement a circular linked list for managing turn order
- Use LinkedLists to manage player hands and the deck
- Understand and apply peek(), poll(), and add() methods
- Reverse the play order dynamically using linked list properties

## Lab Structure

The lab is divided into three progressive parts:

### Part 1: Implementing a Circular Linked List (PlayQueue<E>)

Goal: Create a circular linked list that will manage player turns.

Tasks:

Implement a doubly linked circular list in PlayQueue<E>.

Implement the following methods:

add(E element): Adds a player to the turn queue.

getNext(): Retrieves the next player in order.

reverseDirection(): Changes traversal direction.

size(): Returns the number of players.

Ensure that players cycle through in both forward and reverse directions correctly.

### Part 2: Managing Hands & Card Actions

Goal: Use linked list operations to manage a player's hand of cards.

Tasks:

Store a player's hand as a linked list.

Implement the following methods in Player:

drawCard(Card card): Adds a card to the hand.

handSize(): Returns the number of cards.

attemptToPlay(Card topOfDiscard): Finds a playable card and removes it.

Ensure that attemptToPlay() correctly follows UNO rules (e.g., match by color or value).

### Part 3: Implementing Gameplay in UNO

Goal: Integrate PlayQueue and Player to manage the full turn-based game logic.

Tasks:

Implement a deck as a linked list.

Implement the following game mechanics:

buildDeck(): Generates and shuffles the deck.

shuffleDeck(): Randomizes card order.

play(): Controls the game loop, handling turns and play order.

Handle special card effects:

Reverse card calls reverseDirection() on PlayQueue.

Ensure deck refills from discard pile when empty.

### Additional Challenges

Implement Draw Two and Skip cards.

Add Wild and Wild Draw Four cards.

Implement an AI player that makes smarter card choices.

## Summary

This lab will give us a chance to improve our skills both with using LinkedLists and implementing a circular linked list.