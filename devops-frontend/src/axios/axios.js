import axios from "axios";

const instance = axios.create({
    baseURL: 'backend-service',
    headers: {
        'Access-Control-Allow-Origin': '*',
    }
})

export default instance;
