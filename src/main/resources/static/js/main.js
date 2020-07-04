import Vue from 'vue'
import 'api/resource'
import Vuetify from 'vuetify'
import '@babel/polyfill'
import App from 'pages/App.vue'
import store from 'store/store'
import { connect } from './util/ws'
import 'vuetify/dist/vuetify.min.css'


if (frontendData.profile) {
    connect();
}

Vue.use(Vuetify)

new Vue({
    vuetify : new Vuetify(),
    el: '#app',
    store,
    render: a => a(App)
})
