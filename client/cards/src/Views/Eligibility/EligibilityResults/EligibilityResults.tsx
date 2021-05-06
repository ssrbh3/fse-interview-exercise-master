import React from "react";
import styled from "styled-components";
import {useSelector} from "react-redux";
import {RootStore} from "../../../redux/Store";
import Title from "../../../DesignSystem/Title";
import View from "../../../DesignSystem/View";
import Card from "../../../DesignSystem/Card";
import {useHistory} from "react-router-dom";
import { Button } from "../../../DesignSystem/Form/SubmitButton/SubmitButton";
import {FormWrapper} from "../EligibilityApplication/EligibilityApplication";

const ResultsWrapper = styled.div`
  flex: 1 1 auto;
  padding-top: 48px;
  justify-content: center;
  margin: 0 -8px;
  display: flex;
  flex-wrap: wrap;
`;

const EligibilityResults = () => {
    const cards = useSelector((state: RootStore) => state.cardReducer)
    let object: MyObj = JSON.parse(JSON.stringify(cards));
    if (object.cards !== undefined && object.cards.eligibleCards !== undefined && object.cards.eligibleCards.length > 0) {
        return <ResultsWrapper>
            <Title>Result</Title>
            <h4>Brilliant !! you are eligible for following cards

                {
                    object.cards.eligibleCards.map((element, index) => {
                        return (
                            <Card>
                                <div key={element + index}>
                                    <li>{element}</li>
                                </div>
                            </Card>
                        )
                    })
                }
            </h4>
            <FormWrapper>
                <Back/>
            </FormWrapper>

        </ResultsWrapper>
    } else
        return (
            <ResultsWrapper>
                <Title>Result</Title>
                <View>
                    <h4>Sorry You are not eligible for any card, Please contact TradeLedger for more information.</h4>
                </View>
                <FormWrapper>
                    <Back/>
                </FormWrapper>
            </ResultsWrapper>
        );

};

interface MyObj {
    cards: {
        eligibleCards: []
    }
}

export const Back = () => {
    let history = useHistory();
    return <Button onClick={() => {
        history.push('/')
    }
    }>Back</Button>
}

export default EligibilityResults;
