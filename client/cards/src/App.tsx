import React from "react";
import styled from "styled-components";
import Eligibility from "./Views/Eligibility";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import EligibilityResults from "./Views/Eligibility/EligibilityResults";

const AppWrapper = styled.div`
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  padding: 40px;
`;

const App = () => {
  return (
      <AppWrapper>
          <BrowserRouter>
              <div>
                  <Switch>
                      <Route path="/" component={Eligibility} exact/>
                      <Route path="/result" component={EligibilityResults} exact/>
                  </Switch>
              </div>
          </BrowserRouter>
      </AppWrapper>

  );
};

export default App;
