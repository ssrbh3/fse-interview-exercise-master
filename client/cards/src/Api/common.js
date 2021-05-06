import axios from "axios";

export const GetCards = (values, url) => {
    const headers = {
        'Content-Type': "application/json",
    }

    const requestOptions = {
        body: JSON.stringify(values)
    };

    return axios.post(url, requestOptions.body,
        {headers: headers})
        .then(response => {
            return response
        })
        .catch(error => {
            alert('Oops! There have been an issue connecting to the servers , Please try in a while.')
            throw new Error(error.response) ;
        })
};
