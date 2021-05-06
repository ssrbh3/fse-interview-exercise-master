import React from "react";
import {useFormik} from "formik";
import styled from "styled-components";

import FormInput from "../../../DesignSystem/Form/FormInput";
import SubmitButton from "../../../DesignSystem/Form/SubmitButton";
import Title from "../../../DesignSystem/Title";
import {useHistory} from 'react-router-dom';
import {useDispatch} from "react-redux";
import {GetCards} from "../../../Api/common";
import {setCards} from "../../../redux/actions/cardsActions";

export const FormWrapper = styled.div`
  flex: 1 1 auto;
  width: 100%;
`;

interface FormValues {
    name: string;
    email: string;
    address: string;
}

const EligibilityApplication = () => {
    let history = useHistory();
    const dispatch = useDispatch();
    const url = `http://localhost:8080/check-eligibility`
    const {handleChange, handleSubmit, values} = useFormik<FormValues>({
        initialValues: {
            name: "",
            email: "",
            address: "",
        },
        onSubmit: async (values) => {
            await GetCards(values, url).then(r =>
                dispatch(setCards(r.data))
            )
            history.push('/result')
        },
    });
    return (
        <FormWrapper>
            <Title>Cards</Title>
            <form onSubmit={handleSubmit}>
                <FormInput
                    type="text"
                    name="name"
                    id="name"
                    onChange={handleChange}
                    value={values.name}
                    placeholder="Name"
                    required={true}
                />
                <FormInput
                    type="email"
                    name="email"
                    id="email"
                    onChange={handleChange}
                    value={values.email}
                    placeholder="Email"
                    required={true}
                />
                <FormInput
                    type="text"
                    name="address"
                    id="address"
                    onChange={handleChange}
                    value={values.address}
                    placeholder="Address"
                    required={true}
                />
                <SubmitButton text="Submit"/>
            </form>
        </FormWrapper>
    );
};

export default EligibilityApplication;
