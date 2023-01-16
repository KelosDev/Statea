/** @type {import('next').NextConfig} */


const nextConfig = {
  eslint: {
    // Warning: This allows production builds to successfully complete even if
    // your project has ESLint errors.
    ignoreDuringBuilds: true,
  },
  reactStrictMode: true,
  swcMinify: true,
  output: 'standalone',
}

module.exports = nextConfig

module.exports = {
  i18n: {
    locales: ['it'],
    defaultLocale: 'it',
  },
};

