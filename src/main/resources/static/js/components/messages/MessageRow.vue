<template>
    <v-card class="my-2">
        <v-card-text >
            <i>({{  message.id }})</i>
            <span class="subtitle-2">{{ message.text }}</span>
        </v-card-text>
        <v-card-actions >
            <v-btn value="Edit" @click="edit" small text rounded>Edit</v-btn>
            <v-btn icon @click="del" small >
                <v-icon>{{ remove }}</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
    import { mdiDelete } from '@mdi/js'

    export default {
        props: ['message', 'editMessage', 'deleteMessage', 'messages'],
        data() {
            return {
                remove: mdiDelete,
            }
        },
        methods: {
            edit() {
                this.editMessage(this.message)
            },
            del() {
                this.deleteMessage(this.message)
            }
        }
    }
</script>

<style>
</style>