import React, { Component } from 'react';
import CurrencyConvertor from './CurrencyConvertor';
import './style.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };

    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
  }

  increment() {
    this.setState((prevState) => ({ count: prevState.count + 1 }));
  }

  decrement() {
    this.setState((prevState) => ({ count: prevState.count - 1 }));
  }

  sayHello() {
    alert('Hello Member!');
  }

  incrementAndHello = () => {
    this.increment();
    this.sayHello();
  };

  sayWelcome(message) {
    alert(message);
  }

  handleSyntheticEvent = (event) => {
    alert('I was clicked');
    console.log('Synthetic event:', event);
  };

  render() {
    return (
      <div className="container">
        <h2>{this.state.count}</h2>

        <div className="buttons">
          <button onClick={this.incrementAndHello}>Increment</button>
          <button onClick={this.decrement}>Decrement</button>
          <button onClick={() => this.sayWelcome('welcome')}>Say welcome</button>
          <button onClick={this.handleSyntheticEvent}>Click on me</button>
        </div>

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
