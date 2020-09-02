export class User {
    constructor(
        public name: string,
        public email: string,
        public phone: string,
        public topic: string,
        public timePreferences: string,
        public subscribe: boolean
    ) { }
}
