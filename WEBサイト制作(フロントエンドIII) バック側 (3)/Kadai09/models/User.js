import mongoose from "mongoose";

// スキーマの定義
const userSchema = new mongoose.Schema({
    name: { type: String, required: true },
    email: { type: String, required: true, unique: true },
    password: { type: String, required: true }});

// モデル作成
const User = mongoose.model('User', userSchema);

export default User;