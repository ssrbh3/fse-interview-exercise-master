import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';
import EligibilityApplication from "./Views/Eligibility/EligibilityApplication";
import ReactDOM from 'react-dom';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/Cards/i);
  expect(linkElement).toBeInTheDocument();
});


/*describe('EligibilityApplication test', ()=>{
  let container : HTMLDivElement

  beforeEach(()=>{

    container = document.createElement('div');
    document.body.appendChild(container);
    ReactDOM.render(<EligibilityApplication/>, container);
  })

  afterEach(()=>{
    document.body.removeChild(container);
    container.remove();
  })

  it('Renders Cards page correctly', ()=>{

    const input = container.querySelectorAll('input');
    expect(input).toHaveLength(3);


  })

})*/
