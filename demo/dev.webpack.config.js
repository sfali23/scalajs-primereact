const generatedConfig = require("./scalajs.webpack.config");
const path = require("path");

module.exports = generatedConfig;

module.exports = {
    "entry": {
        "demo-fastopt": ["./demo-fastopt.js"]
    },
    mode: "development",
    performance: {
        maxEntrypointSize: 400000
    },
    devServer: {
        contentBase: [
            __dirname,
            path.join(__dirname, "../../../../src/main/resources")
        ],
        watchContentBase: true
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                use: [
                    "style-loader",
                    "css-loader"
                ]
            },
            {
                test: /\.(png|woff|woff2|eot|ttf|svg)$/,
                use: [
                    {
                        loader: 'url-loader'
                    },
                ]
            },
            {
                test: /\.(png|jpe?g|gif)$/i,
                use: [
                    {
                        loader: 'file-loader',
                    },
                ],
            }
        ]
    }
};
