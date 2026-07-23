import React from 'react';

export function ListofPlayers({ players }) {
  return <ul>{players.map((item, i) =>
    <li key={i}>Mr. {item.name} {item.score}</li>
  )}</ul>;
}

export function Scorebelow70({ players }) {
  const players70 = players.filter(item => item.score <= 70);
  return <ul>{players70.map((item, i) =>
    <li key={i}>Mr. {item.name} {item.score}</li>
  )}</ul>;
}
