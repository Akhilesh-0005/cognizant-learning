import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      currency: ''
    };
  }

  handleAmountChange = (event) => {
    this.setState({ amount: event.target.value });
  };

  handleCurrencyChange = (event) => {
    this.setState({ currency: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const amount = parseFloat(this.state.amount);
    const currency = this.state.currency.trim().toLowerCase();

    if (Number.isNaN(amount)) {
      alert('Please enter a valid amount.');
      return;
    }

    if (currency === 'euro') {
      // Conversion used to match the hands-on example:
      // 80 Euro -> Rs. 6400
      const rupees = amount * 80;
      alert(`Converting to Indian Rupees is ${rupees}`);
    } else {
      alert('Please enter "Euro" as the currency.');
    }
  };

  render() {
    return (
      <div className="converter">
        <h1>Currency Convertor!!!</h1>

        <form onSubmit={this.handleSubmit}>
          <div className="form-row">
            <label htmlFor="amount">Amount:</label>
            <input
              id="amount"
              type="number"
              value={this.state.amount}
              onChange={this.handleAmountChange}
            />
          </div>

          <div className="form-row">
            <label htmlFor="currency">Currency:</label>
            <input
              id="currency"
              type="text"
              value={this.state.currency}
              onChange={this.handleCurrencyChange}
            />
          </div>

          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;
