import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import Footer from './Footer'

class Header extends Component {

  constructor(props){
    super(props)
    this.state = {
      message:"visitiaml"
    }
  }

  provaClicked = async () => {
    console.log("ti dico un complimento")
    const compliment_obj = await fetch("https://complimentr.com/api").then(r =>
      r.json()
      )
    // fetcho un complimento

    this.setState({
      message:compliment_obj.compliment
    })
  }

  render() {
    const {title} = this.props
    const {message} = this.state
    return (
      <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1>{title}</h1>
          <h2>{message}</h2>
          <button onClick={this.provaClicked}>Prova</button>
      </header>
    )
  }
}

class App extends Component {
  render() {
    return (
      <div className="App">
          <Header title="bevia.ml" />
          <Footer/>
      </div>
    );
  }
}

export default App;
