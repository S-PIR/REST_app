
import Vue from 'vue'
import VueResource from 'vue-resource'
import 'vuetify/dist/vuetify.min.css'
import Vuetify from 'vuetify'
import App from 'pages/App.vue'
import { connect } from './util/ws'


if (frontendData.profile) {
    connect();
}

Vue.use(Vuetify,{ iconfont: 'mdiSvg' })
Vue.use(VueResource)

new Vue({
    vuetify : new Vuetify(),
    el: '#app',
    render: a => a(App)
})
